package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "daily_meals")
public class DailyMeal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private DineType dineType;

    @ManyToOne
    private Meal meal;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dailyMealId")
    private Collection<DailyMealRating> dailyMealRatings = new ArrayList<>();

    private LocalDate date;

    public DailyMeal(DineType dineType, Meal meal, LocalDate date) {
        this.dineType = dineType;
        this.meal = meal;
        this.date = date;
    }
}
