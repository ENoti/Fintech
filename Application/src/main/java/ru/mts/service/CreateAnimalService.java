package ru.mts.service;

import ru.mts.entity.AbstractAnimal;

import java.util.List;
import java.util.Map;

public interface CreateAnimalService {

    default AbstractAnimal choiceAnimal(int type){
        return null;
    }

    default Map<String, List<AbstractAnimal>> createMasAnimal(){
        return null;
    }
}
