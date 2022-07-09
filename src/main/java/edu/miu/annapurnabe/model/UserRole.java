package edu.miu.annapurnabe.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author bijayshrestha on 7/6/22
 * @project annapurna-be
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="user_roles")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean status;

    public UserRole(String name, boolean status) {
        this.name = name;
        this.status = status;
    }
}
