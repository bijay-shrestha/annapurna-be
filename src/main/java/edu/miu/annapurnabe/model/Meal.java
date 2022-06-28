package edu.miu.annapurnabe.model;

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
public class Meal {
    private static final Character DISABLE = 'D';
    private static final Character ACTIVE = 'A';

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="status")
    private Character status = ACTIVE;

    public Meal(String name) {
        this.name = name;
    }

    public void disable(){
        this.status = DISABLE;
    }
}
