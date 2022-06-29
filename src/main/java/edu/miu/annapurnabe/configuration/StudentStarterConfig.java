package edu.miu.annapurnabe.configuration;

import at.favre.lib.crypto.bcrypt.BCrypt;
import edu.miu.annapurnabe.model.Student;
import edu.miu.annapurnabe.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import static edu.miu.annapurnabe.constant.BCryptConstant.COST;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 * @reference for bcrypt: https://github.com/patrickfav/bcrypt
 */
@Order(value = 1)
@Component
public class StudentStarterConfig implements CommandLineRunner{
    @Resource
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student bijay = new Student(
                613783,
                "Bijay Shrestha",
                "xyz@miu.edu",
                "bijay",
                BCrypt.withDefaults().hashToString(COST, "bijay".toCharArray()),
                LocalDate.of(1990, Month.JANUARY, 5),
                'A',
                true);

        Student shelly = new Student(
                613701,
                "Shelly Neira",
                "ssh@miu.edu",
                "shelly",
                BCrypt.withDefaults().hashToString(COST, "shelly".toCharArray()),
                LocalDate.of(2015, Month.FEBRUARY, 14),
                'A',
                true);

        Student derartu = new Student(
                613701,
                "Derartu Abdisa",
                "hello@miu.edu",
                "derartu",
                BCrypt.withDefaults().hashToString(COST, "derartu".toCharArray()),
                LocalDate.of(2000, Month.MARCH, 10),
                'A',
                true);
        studentRepository.saveAll(List.of(bijay, shelly, derartu));
    }
}
