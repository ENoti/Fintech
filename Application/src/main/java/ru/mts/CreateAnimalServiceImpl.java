package ru.mts;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
public class CreateAnimalServiceImpl implements CreateAnimalService {

    List<String> name = Arrays.asList("Фродо", "Рыжий", "Леопольд","Сосиска", "Джордж",
            "Тарзан","Клык", "Шпик", "Рыг", "Вулф", "Ауф", "Уффф");
    int rand = (int) (Math.random() * 12);

    @Bean
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

    public AbstractAnimal[] testSearch(AbstractAnimal[] arrayAnimal){
        arrayAnimal[0] = choiceAnimal(0);
        arrayAnimal[0].name = "TestName";
        arrayAnimal[0].cost = BigDecimal.valueOf(0);
        arrayAnimal[0].birthDate = LocalDate.parse("2002-06-28");
        arrayAnimal[0].breed = "Королевский род";
        arrayAnimal[0].character = "Норм чел";

        arrayAnimal[1] = choiceAnimal(0);
        arrayAnimal[1].name = "TestName";
        arrayAnimal[1].cost = BigDecimal.valueOf(0);
        arrayAnimal[1].birthDate = LocalDate.parse("2002-06-28");
        arrayAnimal[1].breed = "Королевский род";
        arrayAnimal[1].character = "Норм чел";

        return arrayAnimal;
    }

    AbstractAnimal typeAnimal = null;

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

    public AbstractAnimal[] createMasAnimal(int N){
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        while (N != 0) {
            arrayAnimal[arrayAnimal.length-N] = createAnimal();
            arrayAnimal[arrayAnimal.length-N].name = name.get(rand);
            N--;
        }
        return arrayAnimal;
    }

    public AbstractAnimal[] createMasAnimal(){
        int N = 10;
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        arrayAnimal = testSearch(arrayAnimal);
        N -= 2;
        do{
            arrayAnimal[arrayAnimal.length-N] = createAnimal();
            arrayAnimal[arrayAnimal.length-N].name = name.get(rand);
            N--;
        }while (N!=0);
        return arrayAnimal;
    }
}
