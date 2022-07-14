package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.dto.request.InsightRequestDTO;
import edu.miu.annapurnabe.model.DailyMealRating;
import edu.miu.annapurnabe.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
@Repository
public interface DailyMealRatingRepository extends JpaRepository<DailyMealRating,Long> {
    @Query(nativeQuery = true, value = "SELECT *\n" +
            "FROM (\n" +
            "SELECT MAX(ratingStatus.rating) as rate,ratingStatus.id as daily_meal_rating_id," +
            "ratingStatus.name, ratingStatus.description, ratingStatus.contains_dairy," +
            "ratingStatus.contains_gluten, ratingStatus.contains_sugar FROM (\n" +
            "select COUNT(dmr.rating) as rating, dmr.id, m.name as name, m.description," +
            "m.contains_dairy, m.contains_gluten, m.contains_sugar \n" +
            "from daily_meal_rating dmr\n" +
            "JOIN daily_meal_user_ratings dmur on dmur.daily_meal_ratings_id =dmr .id \n" +
            "JOIN daily_meals dm on dm.id=dmr.daily_meal_id\n" +
            "JOIN meals m on m.id=dm.meal_id\n" +
            "JOIN users u on u.id=dmur.users_id \n" +
            "WHERE dmr.rating =:ratingStatus and dmr.rating_date BETWEEN :fromDate AND :toDate \n" +
            "GROUP BY m.name\n" +
            "order by m.name DESC) as ratingStatus\n" +
            "GROUP  by ratingStatus.name) as totalRate\n" +
            "LIMIT 2")
    List<Object[]> findTopTwoMealsWithMostRatingStatus(@Param("ratingStatus") String ratingStatus,
                                                       @Param("fromDate") String fromDate,
                                                       @Param("toDate") String toDate);
}
