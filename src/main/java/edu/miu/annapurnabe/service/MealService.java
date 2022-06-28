package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.request.MealRequestDTO;
import edu.miu.annapurnabe.dto.request.MealUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.MealResponseDTO;

import java.util.List;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
public interface MealService {

    List<MealResponseDTO> getMeals();

    MealResponseDTO getMealById(Integer mealId);

    MealResponseDTO saveMeal(MealRequestDTO mealRequestDTO);

    MealResponseDTO updateMeal(Integer mealId, MealUpdateRequestDTO mealUpdateRequestDTO);

    MealResponseDTO deleteMeal(Integer mealId);
}
