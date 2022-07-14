package edu.miu.annapurnabe.api.v1;

import edu.miu.annapurnabe.dto.request.InsightRequestDTO;
import edu.miu.annapurnabe.dto.response.TopMealResponseDetailDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;
import edu.miu.annapurnabe.service.DailyMealRatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.DailyMealResourceConstant.DAILY_MEALS;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.InsightResourceConstant.ANNAPURNA_INSIGHT;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.InsightResourceConstant.TOP_TWO_RATING_STATUS;

/**
 * @author bijayshrestha on 7/14/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + ANNAPURNA_INSIGHT)
public class AnnapurnaInsightResource {

    private final DailyMealRatingService dailyMealRatingService;

    public AnnapurnaInsightResource(DailyMealRatingService dailyMealRatingService) {
        this.dailyMealRatingService = dailyMealRatingService;
    }

    @GetMapping(TOP_TWO_RATING_STATUS)
    public ResponseEntity<List<TopMealResponseDetailDTO>>
    getMealWithMostRatingStatus(@PathVariable String ratingStatus,
                                @RequestBody InsightRequestDTO insightRequestDTO)
            throws DataNotFoundException {
        return ResponseEntity.ok(dailyMealRatingService
                .findTopTwoMealsWithMostRatingStatus(ratingStatus, insightRequestDTO));
    }

}
