package ru.mts;

import java.util.ArrayList;

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
