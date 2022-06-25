package edu.miu.annapurnabe.configuration;

import at.favre.lib.crypto.bcrypt.BCrypt;
import edu.miu.annapurnabe.model.Student;
import edu.miu.annapurnabe.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 * @reference for bcrypt: https://github.com/patrickfav/bcrypt
 */
@Configuration
public class StudentStarterConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {

            Student bijay = new Student(
                    613783,
                    "Bijay Shrestha",
                    "bijayshrestha@miu.edu",
                    "bijay",
                    BCrypt.withDefaults().hashToString(12, "bijay".toCharArray()),
                    LocalDate.of(1990, Month.JANUARY, 5),
                    'Y',
                    true);

            Student shelly = new Student(
                    613701,
                    "Shelly Neira",
                    "shellyneira@miu.edu",
                    "shelly",
                    BCrypt.withDefaults().hashToString(12, "shelly".toCharArray()),
                    LocalDate.of(2015, Month.FEBRUARY, 14),
                    'Y',
                    true);

            Student derartu = new Student(
                    613701,
                    "Derartu Abdisa",
                    "derartu@miu.edu",
                    "derartu",
                    BCrypt.withDefaults().hashToString(12, "derartu".toCharArray()),
                    LocalDate.of(2000, Month.MARCH, 10),
                    'Y',
                    true);

            studentRepository.saveAll(List.of(bijay, shelly, derartu));
        };
    }
}
