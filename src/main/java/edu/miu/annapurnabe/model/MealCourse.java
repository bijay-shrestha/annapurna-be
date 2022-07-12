package edu.miu.annapurnabe.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal_course")
public class MealCourse implements Serializable {
    private static final Character DISABLE = 'D';
    private static final Character ACTIVE = 'A';

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Character status = ACTIVE;

    public MealCourse(String name) {
        this.name = name;
    }

    public void disable(){
        this.status = DISABLE;
    }
}
