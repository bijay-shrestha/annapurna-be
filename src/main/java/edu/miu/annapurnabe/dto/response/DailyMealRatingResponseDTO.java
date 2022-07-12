package edu.miu.annapurnabe.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
@Getter
@Setter
public class DailyMealRatingResponseDTO implements Serializable {
    private Integer dailyMealRatingId;
    private Integer userId;
    private String rating;
    private String message;
}
