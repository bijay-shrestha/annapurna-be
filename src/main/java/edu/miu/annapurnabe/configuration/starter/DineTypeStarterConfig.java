package edu.miu.annapurnabe.configuration.starter;

import edu.miu.annapurnabe.model.DineType;
import edu.miu.annapurnabe.repository.DineTypeRepository;
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
@Order(value = 3)
@Component
@Slf4j
public class DineTypeStarterConfig implements CommandLineRunner{
    @Resource
    private DineTypeRepository dineTypeRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("--------- RUNNING DINE TYPE CONFIG 3 ----------------");
        DineType breakfast = new DineType("Breakfast");
        DineType lunch = new DineType("Lunch");
        DineType dinner = new DineType("Dinner");
        dineTypeRepository.saveAll(List.of(breakfast, lunch, dinner));
    }
}