package ru.mts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CreateConfiguration {
    @Bean
    @Scope("prototype")
    CreateAnimalService createAnimalService(){
        return new CreateAnimalServiceImpl();
    }
}
