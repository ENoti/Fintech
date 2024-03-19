package ru.mts.repository;

import ru.mts.entity.AbstractAnimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AnimalsRepository {

    default Map<String, LocalDate> findLeapYearNames(){
        return new HashMap<>();
    }
    default Map<AbstractAnimal, Integer> findOlderAnimal(int N){
        return new HashMap<>();
    }
    default Map<String, Integer> findDuplicateFalse(){
        return new HashMap<>();
    }
    default Map<String, Integer> findDuplicateTrue(){
        return new HashMap<>();
    }

    default double findAverageAge(){ return 0; }
    default List<AbstractAnimal> findOldAndExpensive(){
        return new ArrayList<>();
    }
    default List<String> findMinConstAnimals(){
        return new ArrayList<>();
    }
    default List<String> findMinConstAnimals(Map<String, List<AbstractAnimal>> abstractAnimals){
        return new ArrayList<>();
    }

}
