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

import static edu.miu.annapurnabe.DailyMealUtils.convertObjectListToResponse;

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
        List<DineType> dineTypes = dineTypeRepository.findAll();
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
        List<Object[]> fruits =  dailyMealRepository
                .getTodayMeal(dailyMealRequestDTO.getTodayDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "fruits", dineType);
        List<MealResponseDetailDTO> fruitsObj = convertObjectListToResponse.apply(fruits);
        dailyMealDetailResponseDTO.setFruits(fruitsObj);

        List<Object[]> dessert =  dailyMealRepository
                .getTodayMeal(dailyMealRequestDTO.getTodayDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),"dessert", dineType);
        List<MealResponseDetailDTO> desertObj = convertObjectListToResponse.apply(dessert);
        dailyMealDetailResponseDTO.setDessert(desertObj);

        List<Object[]> main =  dailyMealRepository
                .getTodayMeal(dailyMealRequestDTO.getTodayDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),"main", dineType);
        List<MealResponseDetailDTO> mainObj = convertObjectListToResponse.apply(main);
        dailyMealDetailResponseDTO.setMain(mainObj);

        List<Object[]> soup =  dailyMealRepository
                .getTodayMeal(dailyMealRequestDTO.getTodayDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),"soup", dineType);
        List<MealResponseDetailDTO> soupObj = convertObjectListToResponse.apply(soup);
        dailyMealDetailResponseDTO.setSoup(soupObj);

        return dailyMealDetailResponseDTO;

    }
}
