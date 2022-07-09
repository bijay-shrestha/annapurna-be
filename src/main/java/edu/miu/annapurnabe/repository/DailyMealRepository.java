package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.dto.response.DailyMealResponseDTO;
import edu.miu.annapurnabe.model.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Integer> {

    @Query(nativeQuery = true, value = "select \n" +
            "dm.id,\n" +
            "m.name as meal_name,\n" +
            "m.description,\n" +
            "m.contains_dairy,\n" +
            "m.contains_gluten, \n" +
            "m.contains_sugar \n" +
            "from daily_meals dm \n" +
            "LEFT JOIN dine_type dt ON dm.dine_type_id=dt.id \n" +
            "LEFT JOIN meals m ON dm.meal_id=m.id \n" +
            "LEFT JOIN meal_course mc ON m.meal_course_id=mc.id\n" +
            "where dm.date=:todayDate and mc.name=:mealCourseName " +
            "and dt.name=:dineTypeName \n" +
            "order by dt.id")
    List<Object[]> getTodayMeal(@Param("todayDate") String todayDate,
                                String mealCourseName,
                                String dineTypeName);

}
