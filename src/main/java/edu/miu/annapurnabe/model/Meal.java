package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meals")
public class Meal implements Serializable {
    private static final Character DISABLE = 'D';
    private static final Character ACTIVE = 'A';

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    private String description;
    private boolean containsGluten;
    private boolean containsSugar;
    private boolean containsDairy;

    @ManyToOne
    private MealCourse mealCourse;

    @Column(name="status")
    private Character status = ACTIVE;

    public Meal(String name, MealCourse mealCourse) {
        this.name = name;
        this.mealCourse = mealCourse;
    }

    public Meal(String name,
                String description,
                MealCourse mealCourse,
                boolean containsGluten,
                boolean containsSugar,
                boolean containsDairy) {
        this.name = name;
        this.description = description;
        this.containsGluten = containsGluten;
        this.containsSugar = containsSugar;
        this.containsDairy = containsDairy;
        this.mealCourse = mealCourse;
    }

    public void disable(){
        this.status = DISABLE;
    }
}
