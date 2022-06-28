package edu.miu.annapurnabe.dto.request;

import lombok.Data;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Data
public class MealUpdateRequestDTO {
    private String name;
    private Character status;
}
