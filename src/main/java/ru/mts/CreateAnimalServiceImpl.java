package ru.mts;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    public AbstractAnimal choiceAnimal(int type){
        return switch (type) {
            case 0 -> new Dog();
            case 1 -> new Cat();
            case 2 -> new Wolf();
            case 3 -> new Shark();
            default -> null;
        };
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

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        int rand = (int) (Math.random() * 4);
        typeAnimal = choiceAnimal(rand);
        return bean;
    }

    public AbstractAnimal[] createMasAnimal(int N){
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        while (N != 0) {
            arrayAnimal[arrayAnimal.length-N] = createAnimal();
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
            N--;
        }while (N!=0);
        return arrayAnimal;
    }
}
