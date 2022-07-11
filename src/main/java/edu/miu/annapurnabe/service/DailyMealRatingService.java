package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.request.DailyMealRatingRequestDTO;
import edu.miu.annapurnabe.dto.response.DailyMealRatingResponseDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
public interface DailyMealRatingService {
    DailyMealRatingResponseDTO addDailyMealRating(DailyMealRatingRequestDTO dailyMealRatingRequestDTO) throws DataNotFoundException;
}
