package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.request.DailyMealRequestDTO;
import edu.miu.annapurnabe.dto.response.DailyMealResponseDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;
import edu.miu.annapurnabe.model.DailyMeal;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
public interface DailyMealService {
    List<DailyMealResponseDTO> getTodayMeal(DailyMealRequestDTO dailyMealRequestDTO)throws DataNotFoundException;
}
