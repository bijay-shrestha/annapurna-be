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
        MealCourse dessert = mealCourseRepository.findByName("dessert");
        MealCourse fruits = mealCourseRepository.findByName("fruits");
        mealRepository.saveAll(
                List.of(
                        new Meal("Apple", "", fruits, false, false, false),
                        new Meal("Orange", "", fruits, false, false, false),
                        new Meal("Banana", "", fruits, false, false, false),
                        new Meal("Pea soup", "", soup, false, false, false),
                        new Meal("Dahl", "", soup, false, false, false),
                        new Meal("Roasted Potatoes", "", main, false, false, false),
                        new Meal("Eggs", "", main, false, false, false),
                        new Meal("Red Sauce", "", main, false, true, false),
                        new Meal("Pasta", "", main, true, false, false),
                        new Meal("Broccoli", "", main, false, false, false),
                        new Meal("Rice", "", main, true, false, false),
                        new Meal("Cinnamon Muffin", "", dessert, true, true, true),
                        new Meal("Ice Cream", "", dessert, false, true, true),
                        new Meal("Yoghurt", "", dessert, false, true, true),
                        new Meal("Banana Cake", "", dessert, true, false, true)
                ));
        List<Object[]> objects = mealRepository.test("Cinnamon Muffin");
        System.out.println("++++++ >>>>" + objects.size());
        System.out.println(objects.get(0)[1]);
        System.out.println(objects.get(0)[0]);


    }
}
