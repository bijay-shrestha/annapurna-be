package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.dto.request.MealRequestDTO;
import edu.miu.annapurnabe.dto.request.MealUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.MealResponseDTO;
import edu.miu.annapurnabe.model.Meal;
import edu.miu.annapurnabe.repository.MealRepository;
import edu.miu.annapurnabe.service.MealService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static edu.miu.annapurnabe.constant.ExceptionMessageConstant.MEAL_NOT_FOUND;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final ModelMapper modelMapper;

    public MealServiceImpl(MealRepository mealRepository, ModelMapper modelMapper) {
        this.mealRepository = mealRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MealResponseDTO> getMeals() {
        return mealRepository.getActiveMeals().stream()
                .map(meal -> modelMapper.map(
                        meal,
                        MealResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MealResponseDTO getMealById(Integer mealId) {
        Optional<Meal> meal = mealRepository.findById(mealId);
        if(meal.isPresent()){
            return modelMapper.map(meal.get(), MealResponseDTO.class);
        }else{
            throw new IllegalStateException(MEAL_NOT_FOUND);
        }
    }

    @Override
    public MealResponseDTO saveMeal(MealRequestDTO mealRequestDTO) {
        Meal mealRequest = modelMapper.map(mealRequestDTO, Meal.class);
        Meal meal = mealRepository.save(mealRequest);
        return modelMapper.map(meal, MealResponseDTO.class);
    }

    @Override
    public MealResponseDTO updateMeal(Integer mealId, MealUpdateRequestDTO mealUpdateRequestDTO) {
        Meal toBeUpdatedMeal = modelMapper.map(mealUpdateRequestDTO, Meal.class);
        Meal meal = mealRepository.findById(mealId).orElseThrow(()-> new IllegalStateException(MEAL_NOT_FOUND));
        mealRepository.save(updateMeal(toBeUpdatedMeal, meal));
        return modelMapper.map(meal, MealResponseDTO.class);
    }

    @Override
    public MealResponseDTO deleteMeal(Integer mealId) {
        Meal meal = mealRepository.findById(mealId).orElseThrow(()-> new IllegalStateException(MEAL_NOT_FOUND));
        meal.disable();
        return modelMapper.map(mealRepository.save(meal), MealResponseDTO.class);
    }

    protected Meal updateMeal(Meal toBeUpdatedMeal, Meal existingMeal){
        existingMeal.setName(toBeUpdatedMeal.getName());
        existingMeal.setStatus(toBeUpdatedMeal.getStatus());
        return existingMeal;
    }
}
