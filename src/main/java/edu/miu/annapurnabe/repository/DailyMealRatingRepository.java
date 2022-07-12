package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.model.DailyMealRating;
import edu.miu.annapurnabe.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bijayshrestha on 7/11/22
 * @project annapurna-be
 */
@Repository
public interface DailyMealRatingRepository extends JpaRepository<DailyMealRating,Long> {
}
