package edu.miu.annapurnabe.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
