package ru.mts;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateAnimalServiceImpl implements CreateAnimalService {

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

    public AbstractAnimal[] createAnimal(int N){
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        int rand;
        while (N != 0) {
            rand = (int) (Math.random() * 4);
            arrayAnimal[arrayAnimal.length-N] = choiceAnimal(rand);
            N--;
        }
        return arrayAnimal;
    }
    public AbstractAnimal[] createAnimal(){
        int N = 10;
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        int rand;
        arrayAnimal = testSearch(arrayAnimal);
        N -= 2;
        do{
            rand = (int) (Math.random() * 4);
            arrayAnimal[arrayAnimal.length-N] = choiceAnimal(rand);
            N--;
        }while (N!=0);
        return arrayAnimal;
    }
}
