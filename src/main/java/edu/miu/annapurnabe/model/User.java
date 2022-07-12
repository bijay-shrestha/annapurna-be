package edu.miu.annapurnabe.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
    private static final Character DISABLE = 'D';
    private static final Character ACTIVE = 'A';

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer userId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "subscribed")
    private boolean subscribed;
    @Column(name = "status")
    private Character status = ACTIVE;

    @ManyToMany(fetch = EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Collection<DailyMealRating> dailyMealRatings = new ArrayList<>();

    public void disable(){
        this.status = DISABLE;
    }

    public User(Integer userId, String fullName,
                String email, String username,
                String password, LocalDate dateOfBirth,
                boolean subscribed, Character status) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.subscribed = subscribed;
        this.status = status;
    }

    public User(Integer userId, String fullName, String email, String username,
                String password, LocalDate dateOfBirth, boolean subscribed,
                Character status, Set<UserRole> userRoles) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.subscribed = subscribed;
        this.status = status;
        this.userRoles = userRoles;
    }
}
