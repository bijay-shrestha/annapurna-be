package edu.miu.annapurnabe;

import edu.miu.annapurnabe.dto.response.MealResponseDetailDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
public class DailyMealUtils {

    public static Function<List<Object[]>, List<MealResponseDetailDTO>>
            convertObjectListToResponse = (objects) -> {

        final Integer DAILY_MEAL_ID = 0;
        final Integer MEAL_NAME = 1;
        final Integer MEAL_DESCRIPTION = 2;
        final Integer CONTAINS_DAIRY = 3;
        final Integer CONTAINS_GLUTEN = 4;
        final Integer CONTAINS_SUGAR = 5;
        List<MealResponseDetailDTO> responseDTOList = new ArrayList<>();

        objects.forEach(o -> {
            MealResponseDetailDTO responseDTO = new MealResponseDetailDTO();
            responseDTO.setId(Long.parseLong(o[DAILY_MEAL_ID].toString()));
            responseDTO.setName(o[MEAL_NAME].toString());
            responseDTO.setDescription(o[MEAL_DESCRIPTION].toString());
            responseDTO.setContainsDairy(Boolean.parseBoolean(o[CONTAINS_DAIRY].toString()));
            responseDTO.setContainsGluten(Boolean.parseBoolean(o[CONTAINS_GLUTEN].toString()));
            responseDTO.setContainsSugar(Boolean.parseBoolean(o[CONTAINS_SUGAR].toString()));
            responseDTOList.add(responseDTO);
        });

        return responseDTOList;
    };

}
