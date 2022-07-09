package edu.miu.annapurnabe.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@Getter
@Setter
public class DailyMealRequestDTO implements Serializable {
    private LocalDate todayDate;
}
