package edu.miu.annapurnabe.configuration;

import edu.miu.annapurnabe.model.DailyMeal;
import edu.miu.annapurnabe.model.DineType;
import edu.miu.annapurnabe.model.Meal;
import edu.miu.annapurnabe.repository.DailyMealRepository;
import edu.miu.annapurnabe.repository.DineTypeRepository;
import edu.miu.annapurnabe.repository.MealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
//TODO: Needs Refactoring
@Order(value = 4)
@Component
@Slf4j
public class DailyMealConfig implements CommandLineRunner {

    @Resource
    private DailyMealRepository dailyMealRepository;

    @Resource
    private DineTypeRepository dineTypeRepository;

    @Resource
    private MealRepository mealRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("--------- RUNNING DAILY MEAL CONFIG 4 ----------------");

        DineType breakFast = dineTypeRepository.findByName("Breakfast")
                .orElseThrow(()->new IllegalStateException("Breakfast doesn't exist"));
        DineType lunch = dineTypeRepository.findByName("Lunch")
                .orElseThrow(()->new IllegalStateException("Lunch doesn't exist"));
        DineType dinner = dineTypeRepository.findByName("Dinner")
                .orElseThrow(()->new IllegalStateException("Dinner doesn't exist"));


        Meal potatoes = mealRepository.findByName("Potatoes")
                .orElseThrow(()->new IllegalStateException("Potatoes doesn't exist"));
        Meal egg = mealRepository.findByName("Egg")
                .orElseThrow(()->new IllegalStateException("Egg doesn't exist"));
        Meal milk = mealRepository.findByName("Milk")
                .orElseThrow(()->new IllegalStateException("Milk doesn't exist"));
        Meal pizza = mealRepository.findByName("Pizza")
                .orElseThrow(()->new IllegalStateException("Pizza doesn't exist"));
        Meal rice = mealRepository.findByName("Rice")
                .orElseThrow(()->new IllegalStateException("Rice doesn't exist"));
        Meal dahl = mealRepository.findByName("Dahl")
                .orElseThrow(()->new IllegalStateException("Dahl doesn't exist"));
        Meal broccoli = mealRepository.findByName("Broccoli")
                .orElseThrow(()->new IllegalStateException("Broccoli doesn't exist"));

        dailyMealRepository.saveAll(
                List.of(
                        new DailyMeal(breakFast, egg, LocalDate.now()),
                        new DailyMeal(breakFast, milk, LocalDate.now()),
                        new DailyMeal(breakFast, potatoes, LocalDate.now()),
                        new DailyMeal(lunch, pizza, LocalDate.now()),
                        new DailyMeal(dinner, rice, LocalDate.now()),
                        new DailyMeal(dinner, dahl, LocalDate.now()),
                        new DailyMeal(dinner, broccoli, LocalDate.now())
                )
        );


    }
}
