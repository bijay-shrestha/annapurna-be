package edu.miu.annapurnabe.api.v1;

import edu.miu.annapurnabe.dto.request.DailyMealRatingRequestDTO;
import edu.miu.annapurnabe.dto.response.DailyMealRatingResponseDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;
import edu.miu.annapurnabe.service.DailyMealRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.DailyMealRatingResourceConstant.DAILY_MEALS_RATING;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + DAILY_MEALS_RATING)
public class DailyMealRatingResource {

    private final DailyMealRatingService dailyMealRatingService;

    public DailyMealRatingResource(DailyMealRatingService dailyMealRatingService) {
        this.dailyMealRatingService = dailyMealRatingService;
    }

    @PostMapping
    public ResponseEntity<DailyMealRatingResponseDTO> addDailyMealRating(
            @RequestBody DailyMealRatingRequestDTO dailyMealRatingRequestDTO) throws DataNotFoundException {
        return new ResponseEntity<DailyMealRatingResponseDTO>(dailyMealRatingService.addDailyMealRating(dailyMealRatingRequestDTO), HttpStatus.CREATED);
    }
}
