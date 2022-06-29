package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public DineType(String name) {
        this.name = name;
    }
}
