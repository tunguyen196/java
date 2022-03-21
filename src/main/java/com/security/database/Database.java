package com.security.database;

import com.security.models.User;
import com.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    private PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {

        //tạo ra đối tượng để chạy thằng command
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                String encoded = new BCryptPasswordEncoder().encode("123456");
                User user1 = new User("tuna", encoded, 0);
                User user2 = new User("tuna1", encoded, 1);
                User user3 = new User("tuna2", encoded, 1);
                logger.info("insert :" + userRepository.save(user1));
                logger.info("insert :" + userRepository.save(user2));
                logger.info("insert :" + userRepository.save(user3));
            }
        };
    }
}
