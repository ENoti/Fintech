package ru.mts;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDate;


@EnableConfigurationProperties(AnimalProperties.class)
public class CreateConfiguration {

    AnimalProperties animalProperties;

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
    @Lazy
    @Autowired
    AbstractAnimal typeAnimal;

    @Bean
    @Scope("prototype")
    public AbstractAnimal createAnimal(){
        int rand = (int) (Math.random() * 4);
        typeAnimal = choiceAnimal(rand);
        return typeAnimal;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        int rand = (int) (Math.random() * 4);
        typeAnimal = choiceAnimal(rand);
        return bean;
    }

}
