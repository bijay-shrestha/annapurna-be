package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    private static final Character DISABLE = 'D';
    private static final Character ACTIVE = 'A';

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private MealCourse mealCourse;

    @Column(name="status")
    private Character status = ACTIVE;

    public Meal(String name, MealCourse mealCourse) {
        this.name = name;
        this.mealCourse = mealCourse;
    }

    public void disable(){
        this.status = DISABLE;
    }
}
