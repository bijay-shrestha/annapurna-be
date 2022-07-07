package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.model.MealCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@Repository
public interface MealCourseRepository extends JpaRepository<MealCourse, Integer> {

    MealCourse findByName(String name);
}
