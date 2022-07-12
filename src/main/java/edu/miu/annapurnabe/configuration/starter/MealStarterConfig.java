package edu.miu.annapurnabe.configuration.starter;

import edu.miu.annapurnabe.model.Meal;
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
@Order(value = 2)
@Component
@Slf4j
public class MealStarterConfig implements CommandLineRunner {

    @Resource
    private MealRepository mealRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("--------- RUNNING MEAL STARTER CONFIG 2 ----------------");
        mealRepository.saveAll(
                List.of(
                        new Meal("Pizza"),
                        new Meal("Bread"),
                        new Meal("Milk"),
                        new Meal("Rice"),
                        new Meal("Dahl"),
                        new Meal("Broccoli"),
                        new Meal("Potatoes"),
                        new Meal ("Coffee"),
                        new Meal("Egg"),
                        new Meal("Chickpeas"),
                        new Meal("Kidney Beans")
                ));
    }
}
