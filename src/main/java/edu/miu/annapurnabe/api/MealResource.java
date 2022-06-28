package edu.miu.annapurnabe.api;

import edu.miu.annapurnabe.dto.request.MealRequestDTO;
import edu.miu.annapurnabe.dto.request.MealUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.MealResponseDTO;
import edu.miu.annapurnabe.service.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.MealResourceConstant.MEAL_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.MealResourceConstant.MEAL_ID;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + MEAL_BASE)
public class MealResource {

    private final MealService mealService;

    public MealResource(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public ResponseEntity<List<MealResponseDTO>> getMeals(){
        return new ResponseEntity<>(mealService.getMeals(), HttpStatus.OK);
    }

    @GetMapping(MEAL_ID)
    public ResponseEntity<MealResponseDTO> getStudentById(@PathVariable Integer mealId){
        return ResponseEntity.ok().body(mealService.getMealById(mealId));
    }

    @PostMapping
    public ResponseEntity<MealResponseDTO> saveMeal(@RequestBody MealRequestDTO mealRequestDTO) {
        return new ResponseEntity<>(mealService.saveMeal(mealRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping(MEAL_ID)
    public ResponseEntity<MealResponseDTO> updateMeal(@PathVariable Integer mealId,
                                                            @RequestBody MealUpdateRequestDTO mealUpdateRequestDTO) {
        MealResponseDTO mealResponseDTO = mealService.updateMeal(mealId, mealUpdateRequestDTO);
        return ResponseEntity.ok().body(mealResponseDTO);
    }

    @DeleteMapping(MEAL_ID)
    public ResponseEntity<MealResponseDTO> deleteMeal(@PathVariable Integer mealId) {
        MealResponseDTO mealToBeDeleted = mealService.deleteMeal(mealId);
        return ResponseEntity.ok().body(mealToBeDeleted);
    }
}
