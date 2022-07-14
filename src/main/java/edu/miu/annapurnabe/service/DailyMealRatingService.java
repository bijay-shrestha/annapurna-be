package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.request.DailyMealRatingRequestDTO;
import edu.miu.annapurnabe.dto.request.InsightRequestDTO;
import edu.miu.annapurnabe.dto.response.DailyMealRatingResponseDTO;
import edu.miu.annapurnabe.dto.response.MealResponseDetailDTO;
import edu.miu.annapurnabe.dto.response.TopMealResponseDetailDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;

import java.util.List;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
public interface DailyMealRatingService {
    DailyMealRatingResponseDTO addDailyMealRating(DailyMealRatingRequestDTO dailyMealRatingRequestDTO) throws DataNotFoundException;

    List<TopMealResponseDetailDTO> findTopTwoMealsWithMostRatingStatus(String ratingStatus,
                                                                       InsightRequestDTO insightRequestDTO) throws DataNotFoundException;
}
