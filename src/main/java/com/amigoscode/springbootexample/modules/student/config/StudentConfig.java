package com.amigoscode.springbootexample.modules.student.config;

import com.amigoscode.springbootexample.modules.student.entities.Student;
import com.amigoscode.springbootexample.modules.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository
    ){
        return args -> {
            Student flavio = new Student(1l,
                    "Flávio","flavio.danilo022@gmailo.com",
                    LocalDate.of(1993,Month.SEPTEMBER,6));

            Student aline = new Student(2l,"Aline","aline@gmailo.com",
                    LocalDate.of(1995,Month.APRIL,17));


            repository.saveAll(
                    List.of(flavio,aline)
            );
        };
    }
}
