package ru.mts;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public interface AnimalsRepository {

    default ArrayList<String> findLeapYearNames(){
        return new ArrayList<>();
    }


    default ArrayList<AbstractAnimal> findOlderAnimal(int N){
        return new ArrayList<>();
    }

    default Boolean findDuplicate(){
        return true;
    }
}
