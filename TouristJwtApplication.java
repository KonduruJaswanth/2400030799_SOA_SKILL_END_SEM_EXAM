package com.example.tourist;

import com.example.tourist.model.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TouristJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(TouristJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner sampleData(TouristRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Tourist("Taj Mahal", "Agra", "India"));
                repository.save(new Tourist("Charminar", "Hyderabad", "India"));
                repository.save(new Tourist("Eiffel Tower", "Paris", "France"));
            }
        };
    }
}
