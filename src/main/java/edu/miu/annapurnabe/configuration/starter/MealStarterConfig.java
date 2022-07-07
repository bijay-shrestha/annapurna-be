package edu.miu.annapurnabe.configuration.starter;

import edu.miu.annapurnabe.model.Meal;
import edu.miu.annapurnabe.model.MealCourse;
import edu.miu.annapurnabe.repository.MealCourseRepository;
import edu.miu.annapurnabe.repository.MealRepository;
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
@Order(value = 4)
@Component
@Slf4j
public class MealStarterConfig implements CommandLineRunner {

    @Resource
    private MealRepository mealRepository;

    @Resource
    private MealCourseRepository mealCourseRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("--------- RUNNING MEAL STARTER CONFIG 4 ----------------");
        MealCourse main = mealCourseRepository.findByName("main");
        MealCourse soup = mealCourseRepository.findByName("soups");
        MealCourse desert = mealCourseRepository.findByName("desert");
        MealCourse fruits = mealCourseRepository.findByName("fruits");
        mealRepository.saveAll(
                List.of(
                        new Meal("Pizza", main),
                        new Meal("Bread",main),
                        new Meal("Milk", main),
                        new Meal("Rice",main),
                        new Meal("Broccoli",main),
                        new Meal("Dahl",soup),
                        new Meal("Pea soup", soup),
                        new Meal("Potatoes", main),
                        new Meal ("Coffee",main),
                        new Meal("Egg", main),
                        new Meal("Chickpeas", main),
                        new Meal("Kidney Beans", main),
                        new Meal("Yoghurt", desert),
                        new Meal("Banana Pancake", desert),
                        new Meal("Orange",fruits)
                ));
    }
}
