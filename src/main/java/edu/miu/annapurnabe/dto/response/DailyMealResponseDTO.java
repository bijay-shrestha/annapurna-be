package edu.miu.annapurnabe.dto.response;

import edu.miu.annapurnabe.model.MealCourse;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@Getter
@Setter
public class DailyMealResponseDTO implements Serializable {

    private String category; // dineType
    private DailyMealDetailResponseDTO meals;


}
