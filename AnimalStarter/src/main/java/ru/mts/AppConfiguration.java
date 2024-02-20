package ru.mts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;


@org.springframework.boot.test.context.TestConfiguration
public class AppConfiguration {

    public AbstractAnimal[] testSearch(AbstractAnimal[] arrayAnimal){
        arrayAnimal[0] = createConfiguration.choiceAnimal(0);
        arrayAnimal[0].name = "TestName";
        arrayAnimal[0].cost = BigDecimal.valueOf(0);
        arrayAnimal[0].birthDate = LocalDate.parse("2002-06-28");
        arrayAnimal[0].breed = "Королевский род";
        arrayAnimal[0].character = "Норм чел";

        arrayAnimal[1] = createConfiguration.choiceAnimal(0);
        arrayAnimal[1].name = "TestName";
        arrayAnimal[1].cost = BigDecimal.valueOf(0);
        arrayAnimal[1].birthDate = LocalDate.parse("2002-06-28");
        arrayAnimal[1].breed = "Королевский род";
        arrayAnimal[1].character = "Норм чел";

        return arrayAnimal;
    }

    @Autowired
    CreateConfiguration createConfiguration;

    @Bean
    public AbstractAnimal[] createMasAnimal(int N){
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        while (N != 0) {
            arrayAnimal[arrayAnimal.length-N] = createConfiguration.createAnimal();
            arrayAnimal[arrayAnimal.length-N].name = createConfiguration.animalProperties.getNameAnimal();
            N--;
        }
        return arrayAnimal;
    }

    @Bean
    public AbstractAnimal[] createMasAnimal(){
        int N = 10;
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        arrayAnimal = testSearch(arrayAnimal);
        N -= 2;
        do{
            arrayAnimal[arrayAnimal.length-N] = createConfiguration.createAnimal();
            arrayAnimal[arrayAnimal.length-N].name = createConfiguration.animalProperties.getNameAnimal();
            N--;
        }while (N!=0);
        return arrayAnimal;
    }

}
