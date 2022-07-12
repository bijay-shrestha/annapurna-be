package edu.miu.annapurnabe.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealRequestDTO implements Serializable {
    private String name;
    private Integer mealCourseId;
}
