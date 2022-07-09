package edu.miu.annapurnabe.configuration.starter;

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
@Order(value = 5)
@Component
@Slf4j
public class DailyMealStarterConfig implements CommandLineRunner {

    @Resource
    private DailyMealRepository dailyMealRepository;

    @Resource
    private DineTypeRepository dineTypeRepository;

    @Resource
    private MealRepository mealRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("--------- RUNNING DAILY MEAL CONFIG 5 ----------------");

        DineType breakFast = dineTypeRepository.findByName("Breakfast")
                .orElseThrow(()->new IllegalStateException("Breakfast doesn't exist"));
        DineType lunch = dineTypeRepository.findByName("Lunch")
                .orElseThrow(()->new IllegalStateException("Lunch doesn't exist"));
        DineType dinner = dineTypeRepository.findByName("Dinner")
                .orElseThrow(()->new IllegalStateException("Dinner doesn't exist"));


        //BREAKFAST
        Meal roastedPotatoes = mealRepository.findByName("Roasted Potatoes")
                .orElseThrow(()->new IllegalStateException("Roasted Potatoes doesn't exist"));
        Meal banana = mealRepository.findByName("Banana")
                .orElseThrow(()->new IllegalStateException("Banana doesn't exist"));
        Meal eggs = mealRepository.findByName("Eggs")
                .orElseThrow(()->new IllegalStateException("Eggs doesn't exist"));
        Meal cinnamonMuffin = mealRepository.findByName("Cinnamon Muffin")
                .orElseThrow(()->new IllegalStateException("Cinnamon Muffin doesn't exist"));

        //LUNCH
        Meal redSauce = mealRepository.findByName("Red Sauce")
                .orElseThrow(()->new IllegalStateException("Red Sauce doesn't exist"));
        Meal pasta = mealRepository.findByName("Pasta")
                .orElseThrow(()->new IllegalStateException("Pasta doesn't exist"));
        Meal dahl = mealRepository.findByName("Dahl")
                .orElseThrow(()->new IllegalStateException("Dahl doesn't exist"));
        Meal peaSoup = mealRepository.findByName("Pea Soup")
                .orElseThrow(()->new IllegalStateException("Pea Soup doesn't exist"));
        Meal bananaCake = mealRepository.findByName("Banana Cake")
                .orElseThrow(()->new IllegalStateException("Banana Cake doesn't exist"));
        Meal yoghurt = mealRepository.findByName("Yoghurt")
                .orElseThrow(()->new IllegalStateException("Yoghurt doesn't exist"));
        Meal orange = mealRepository.findByName("Orange")
                .orElseThrow(()->new IllegalStateException("Orange doesn't exist"));
        Meal apple = mealRepository.findByName("Apple")
                .orElseThrow(()->new IllegalStateException("Apple doesn't exist"));

        //DINNER
        Meal rice = mealRepository.findByName("Rice")
                .orElseThrow(()->new IllegalStateException("Rice doesn't exist"));
        Meal broccoli = mealRepository.findByName("Broccoli")
                .orElseThrow(()->new IllegalStateException("Broccoli doesn't exist"));
        Meal iceCream = mealRepository.findByName("Ice Cream")
                .orElseThrow(()->new IllegalStateException("Broccoli doesn't exist"));

        dailyMealRepository.saveAll(
                List.of(
                        new DailyMeal(breakFast, banana, LocalDate.now()),
                        new DailyMeal(breakFast, eggs, LocalDate.now()),
                        new DailyMeal(breakFast, roastedPotatoes, LocalDate.now()),
                        new DailyMeal(breakFast, cinnamonMuffin, LocalDate.now()),
                        new DailyMeal(lunch, redSauce, LocalDate.now()),
                        new DailyMeal(lunch, pasta, LocalDate.now()),
                        new DailyMeal(lunch, dahl, LocalDate.now()),
                        new DailyMeal(lunch, peaSoup, LocalDate.now()),
                        new DailyMeal(lunch, bananaCake, LocalDate.now()),
                        new DailyMeal(lunch, yoghurt, LocalDate.now()),
                        new DailyMeal(lunch, orange, LocalDate.now()),
                        new DailyMeal(lunch, apple, LocalDate.now()),
                        new DailyMeal(dinner, dahl, LocalDate.now()),
                        new DailyMeal(dinner, peaSoup, LocalDate.now()),
                        new DailyMeal(dinner, rice, LocalDate.now()),
                        new DailyMeal(dinner, broccoli, LocalDate.now()),
                        new DailyMeal(dinner, iceCream, LocalDate.now()),
                        new DailyMeal(dinner, banana, LocalDate.now())
                )
        );
    }
}
