package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private DineType dineType;

    @ManyToOne
    private Meal meal;

    private LocalDate date;

    public DailyMeal(DineType dineType, Meal meal, LocalDate date) {
        this.dineType = dineType;
        this.meal = meal;
        this.date = date;
    }
}
