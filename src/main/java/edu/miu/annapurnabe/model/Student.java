package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private LocalDate dob;
    @Column(nullable = false)
    private Character status;

    public boolean subscribed;

    public Student(Integer studentId,
                   String fullName,
                   String email,
                   String username,
                   String password,
                   LocalDate dob,
                   Character status,
                   boolean subscribed) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.status = status;
        this.subscribed = subscribed;
    }
}
