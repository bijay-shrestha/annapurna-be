package edu.miu.annapurnabe.model;

import lombok.Data;
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
public class Student implements Serializable {
    private static final Character DISABLE = 'D';
    private static final Character ACTIVE = 'A';

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer studentId;
    @Column(nullable = false, length = 100)
    private String fullName;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private Character status = ACTIVE;

    public boolean subscribed;

    public Student(Integer studentId,
                   String fullName,
                   String email,
                   String username,
                   String password,
                   LocalDate dateOfBirth,
                   Character status,
                   boolean subscribed) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.subscribed = subscribed;
    }

    public void disable(){
        this.status = DISABLE;
    }
}
