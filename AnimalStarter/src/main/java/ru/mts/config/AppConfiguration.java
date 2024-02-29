package ru.mts.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.entity.*;
@TestConfiguration
public class AppConfiguration {

    @Bean
    AnimalProperties animalProperties(){
        return new AnimalProperties();
    }

    public AbstractAnimal choiceAnimal(int type) {
        AbstractAnimal abstractAnimal = null;
        switch (type) {
            case 0: {
                abstractAnimal = new Dog();
                break;
            }
            case 1: {
                abstractAnimal = new Cat();
                break;
            }
            case 2: {
                abstractAnimal = new Wolf();
                break;
            }
            case 3: {
                abstractAnimal = new Shark();
                break;
            }
        }
        return abstractAnimal;
    }

    @Bean
    @Scope("prototype")
    public AbstractAnimal createAnimal(){
        int rand = (int) (Math.random() * 4);
        return choiceAnimal(rand);
    }

}
