package edu.miu.annapurnabe.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 7/9/22
 * @project annapurna-be
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "daily_meal_rating")
public class DailyMealRating implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rating_date")
    private LocalDate date;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "daily_meal_user_ratings", joinColumns = @JoinColumn(
            name = "daily_meal_ratings_id", referencedColumnName = "id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = true
    ))
    private Collection<User> users = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private Rating rating;

}
