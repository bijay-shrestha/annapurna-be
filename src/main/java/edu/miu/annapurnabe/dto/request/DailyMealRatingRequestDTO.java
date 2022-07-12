package edu.miu.annapurnabe.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
@Getter
@Setter
public class DailyMealRatingRequestDTO implements Serializable {
    private Integer dailyMealId;
    private Integer userId;
    private String rating;
}
