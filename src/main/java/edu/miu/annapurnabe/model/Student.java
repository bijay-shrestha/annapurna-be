package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer studentId;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "subscribed")
    private boolean subscribed;

    public Student(Integer studentId,
                   String fullName,
                   String email,
                   String username,
                   String password,
                   LocalDate dateOfBirth,
                   Character status,
                   boolean subscribed) {
        super(fullName, email, username, password, status);
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.subscribed = subscribed;
    }

}
