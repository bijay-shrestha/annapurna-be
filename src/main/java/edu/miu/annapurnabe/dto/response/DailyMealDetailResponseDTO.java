package edu.miu.annapurnabe.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author bijayshrestha on 7/8/22
 * @project annapurna-be
 */
@Getter
@Setter
public class DailyMealDetailResponseDTO implements Serializable {
    private Collection<MealResponseDetailDTO> fruits = new ArrayList<>();
    private Collection<MealResponseDetailDTO> main = new ArrayList<>();
    private Collection<MealResponseDetailDTO> dessert = new ArrayList<>();
    private Collection<MealResponseDetailDTO> soup = new ArrayList<>();
}
