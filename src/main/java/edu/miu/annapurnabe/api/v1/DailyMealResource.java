package edu.miu.annapurnabe.api.v1;

import edu.miu.annapurnabe.dto.request.DailyMealRequestDTO;
import edu.miu.annapurnabe.dto.response.DailyMealResponseDTO;
import edu.miu.annapurnabe.exception.DataNotFoundException;
import edu.miu.annapurnabe.model.DailyMeal;
import edu.miu.annapurnabe.service.DailyMealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.DailyMealResourceConstant.DAILY_MEALS;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + DAILY_MEALS)
public class DailyMealResource {

    private final DailyMealService dailyMealService;

    public DailyMealResource(DailyMealService dailyMealService) {
        this.dailyMealService = dailyMealService;
    }

    @GetMapping
    public ResponseEntity<List<DailyMealResponseDTO>> getTodayMeal(@RequestBody DailyMealRequestDTO dailyMealRequestDTO)
            throws DataNotFoundException {
        return new ResponseEntity<>(dailyMealService.getTodayMeal(dailyMealRequestDTO), HttpStatus.OK);
    }
}
