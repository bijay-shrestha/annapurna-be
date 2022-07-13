package edu.miu.annapurnabe.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
    public static final String DAILY_MEAL_RATING_SUCCESS_MESSAGE = ", Thank you, for rating our service!";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "daily_meal_id")
    private DailyMeal dailyMealId;

    @Column(name = "rating_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "daily_meal_user_ratings", joinColumns = @JoinColumn(
            name = "daily_meal_ratings_id", referencedColumnName = "id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = true
    ))
    private Collection<User> users = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private Rating rating;

    public DailyMealRating(DailyMeal dailyMealId, Date date, Collection<User> users, Rating rating) {
        this.dailyMealId = dailyMealId;
        this.date = date;
        this.users = users;
        this.rating = rating;
    }
}
