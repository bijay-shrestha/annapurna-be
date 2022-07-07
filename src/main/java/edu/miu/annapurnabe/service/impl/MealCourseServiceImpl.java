package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.model.MealCourse;
import edu.miu.annapurnabe.repository.MealCourseRepository;
import edu.miu.annapurnabe.repository.MealRepository;
import edu.miu.annapurnabe.service.MealCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project annapurna-be
 */
@Service
@Transactional
public class MealCourseServiceImpl implements MealCourseService {

    private final MealCourseRepository mealCourseRepository;

    public MealCourseServiceImpl(MealCourseRepository mealCourseRepository) {
        this.mealCourseRepository = mealCourseRepository;
    }

    public MealCourse saveMealCourse(MealCourse mealCourse){
        return mealCourseRepository.save(mealCourse);
    }

    public List<MealCourse> saveMealCourses(List<MealCourse> mealCourses){
        return mealCourseRepository.saveAll(mealCourses);
    }
}
