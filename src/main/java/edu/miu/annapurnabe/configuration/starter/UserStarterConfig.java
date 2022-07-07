package edu.miu.annapurnabe.configuration.starter;

import edu.miu.annapurnabe.model.User;
import edu.miu.annapurnabe.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 * @reference for bcrypt: https://github.com/patrickfav/bcrypt
 */
@Order(value = 1)
@Component
@Slf4j
public class UserStarterConfig implements CommandLineRunner {
    @Resource
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        log.info("--------- RUNNING STUDENT STARTER CONFIG 1 ----------------");

        User bijay = new User(
                613783,
                "Bijay Shrestha",
                "xyz@miu.edu",
                "bijay",
                passwordEncoder.encode("bijay"),
                LocalDate.of(1990, Month.JANUARY, 5),
                true,
                'A');

        User shelly = new User(
                613701,
                "Shelly Neira",
                "ssh@miu.edu",
                "shelly",
                passwordEncoder.encode("shelly"),
                LocalDate.of(2015, Month.FEBRUARY, 14),
                true,
                'A');

        User derartu = new User(
                613701,
                "Derartu Abdisa",
                "hello@miu.edu",
                "derartu",
                passwordEncoder.encode("derartu"),
                LocalDate.of(2000, Month.MARCH, 10),
                true,
                'A');
        userRepository.saveAll(List.of(bijay, shelly, derartu));
    }
}
