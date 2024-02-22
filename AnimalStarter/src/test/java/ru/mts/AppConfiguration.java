package ru.mts;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class AppConfiguration {

    @Bean
    AnimalProperties animalProperties(){
        return new AnimalProperties();
    }

}
