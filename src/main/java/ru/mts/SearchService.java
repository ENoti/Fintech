package ru.mts;

import java.util.ArrayList;

public interface SearchService {
    default ArrayList<String> findLeapYearNames(AbstractAnimal[] arrayAnimals){
        return new ArrayList<>();
    }
    default ArrayList<AbstractAnimal> findOlderAnimal(AbstractAnimal[] arrayAnimals, int N){
        return new ArrayList<>();
    }
    default ArrayList<AbstractAnimal> findDuplicate(AbstractAnimal[] arrayAnimals){
        return new ArrayList<>();
    }
}
