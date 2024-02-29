package ru.mts.repository;

import ru.mts.entity.AbstractAnimal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public interface AnimalsRepository {

    default Map<String, LocalDate> findLeapYearNames(){
        return new HashMap<>();
    }

    default Map<AbstractAnimal, Integer> findOlderAnimal(){
        return new HashMap<>();
    }

    default Map<String, Integer> findDuplicate(){
        return new HashMap<>();
    }
}
