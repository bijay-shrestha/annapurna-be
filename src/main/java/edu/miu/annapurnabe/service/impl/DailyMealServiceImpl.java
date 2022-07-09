package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.dto.request.DailyMealRequestDTO;
import edu.miu.annapurnabe.dto.response.DailyMealDetailResponseDTO;
import edu.miu.annapurnabe.dto.response.DailyMealResponseDTO;
import edu.miu.annapurnabe.dto.response.MealResponseDetailDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;
import edu.miu.annapurnabe.model.DineType;
import edu.miu.annapurnabe.repository.DailyMealRepository;
import edu.miu.annapurnabe.repository.DineTypeRepository;
import edu.miu.annapurnabe.service.DailyMealService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.miu.annapurnabe.DailyMealUtils.convertObjectListToResponse;
import static edu.miu.annapurnabe.constant.MealConstants.*;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@Service
@Transactional
public class DailyMealServiceImpl implements DailyMealService {

    private final DailyMealRepository dailyMealRepository;

    private final DineTypeRepository dineTypeRepository;

    public DailyMealServiceImpl(DailyMealRepository dailyMealRepository, DineTypeRepository dineTypeRepository) {
        this.dailyMealRepository = dailyMealRepository;
        this.dineTypeRepository = dineTypeRepository;
    }

    @Override
    public List<DailyMealResponseDTO> getTodayMeal(DailyMealRequestDTO dailyMealRequestDTO) throws DataNotFoundException {
        List<DailyMealResponseDTO> meals= new ArrayList<>();
        List<DineType> dineTypes = Optional.of(dineTypeRepository.findAll()).orElseThrow(()->
                new DataNotFoundException("Dine Type Not Found!", "Dine Type returned null!"));
        dineTypes.forEach(dineType->{
            DailyMealResponseDTO mealResponseDTO = new DailyMealResponseDTO();
            mealResponseDTO.setCategory(dineType.getName());
            mealResponseDTO.setMeals(fetchDailyMealResponse(dailyMealRequestDTO, dineType.getName()));
            meals.add(mealResponseDTO);
        });
        return meals;
    }

    private DailyMealDetailResponseDTO fetchDailyMealResponse(DailyMealRequestDTO dailyMealRequestDTO, String dineType) {
        DailyMealDetailResponseDTO dailyMealDetailResponseDTO = new DailyMealDetailResponseDTO();
        String today = dailyMealRequestDTO.getTodayDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<MealResponseDetailDTO> fruits = convertObjectListToResponse.apply(dailyMealRepository
                .getTodayMeal(today, FRUITS, dineType));
        List<MealResponseDetailDTO> dessert = convertObjectListToResponse.apply(dailyMealRepository
                .getTodayMeal(today,DESSERT, dineType));
        List<MealResponseDetailDTO> main = convertObjectListToResponse.apply(dailyMealRepository
                .getTodayMeal(today,MAIN, dineType));
        List<MealResponseDetailDTO> soup = convertObjectListToResponse.apply(dailyMealRepository
                .getTodayMeal(today, SOUPS, dineType));

        dailyMealDetailResponseDTO.setFruits(fruits);
        dailyMealDetailResponseDTO.setDessert(dessert);
        dailyMealDetailResponseDTO.setMain(main);
        dailyMealDetailResponseDTO.setSoup(soup);
        return dailyMealDetailResponseDTO;

    }
}
