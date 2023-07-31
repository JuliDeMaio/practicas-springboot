package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student julian = new Student(
                    43105507l,
                    "Julian",
                    "juli@mail.com",
                    LocalDate.of(2000, 11, 22)
            );

            Student giuliana = new Student(
                    40222445l,
                    "Giuliana",
                    "giuli@mail.com",
                    LocalDate.of(1995, 5, 10)
            );

            repository.saveAll(List.of(julian, giuliana));
        };
    }
}