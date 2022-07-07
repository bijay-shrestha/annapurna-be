package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.model.MealCourse;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
public interface MealCourseService {
    MealCourse saveMealCourse(MealCourse mealCourse);

    List<MealCourse> saveMealCourses(List<MealCourse> mealCourses);
}
