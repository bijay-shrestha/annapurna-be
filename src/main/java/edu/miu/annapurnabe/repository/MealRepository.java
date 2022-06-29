package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    @Query("SELECT m FROM Meal m WHERE m.status='A'")
    Collection<Meal> getActiveMeals();

    @Query("SELECT m FROM Meal m  WHERE m.id=:mealId AND m.status='A'")
    Optional<Meal> findById(Integer mealId);

    @Query("SELECT m FROM Meal m  WHERE m.name=:name AND m.status='A'")
    Optional<Meal> findByName(String name);
}
