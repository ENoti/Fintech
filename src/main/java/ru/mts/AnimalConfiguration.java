package ru.mts;

import org.springframework.context.annotation.*;

@Configuration
public class AnimalConfiguration {
    @Bean
    AnimalsRepository animalsRepository(){
        return new AnimalsRepositoryImpl();

    }

    @Bean
    @Scope("prototype")
    CreateAnimalService createAnimalService(){
        return new CreateAnimalServiceImpl();
    }

}
