package edu.miu.annapurnabe.configuration.starter;

import edu.miu.annapurnabe.model.DineType;
import edu.miu.annapurnabe.model.MealCourse;
import edu.miu.annapurnabe.repository.DineTypeRepository;
import edu.miu.annapurnabe.service.MealCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Order(value = 2)
@Component
@Slf4j
public class MealCourseStarterConfig implements CommandLineRunner{
    @Resource
    private MealCourseService mealCourseService;

    @Override
    public void run(String... args) throws Exception {

        log.info("--------- RUNNING MEAL COURSE CONFIG 2 ----------------");
        MealCourse fruits = new MealCourse("fruits");
        MealCourse main = new MealCourse("main");
        MealCourse desert = new MealCourse("desert");
        MealCourse soups = new MealCourse("soups");
        mealCourseService.saveMealCourses(List.of(fruits, main, desert, soups));
    }
}