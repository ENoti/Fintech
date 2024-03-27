package ru.mts.service;

import ru.mts.entity.AbstractAnimal;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public interface CreateAnimalService {

    default AbstractAnimal choiceAnimal(int type){
        return null;
    }

    default ConcurrentMap<String, CopyOnWriteArrayList<AbstractAnimal>> createMasAnimal(){
        return null;
    }
}
