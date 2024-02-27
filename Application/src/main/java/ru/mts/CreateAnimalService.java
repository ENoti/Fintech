package ru.mts;

import java.util.List;
import java.util.Map;

public interface CreateAnimalService {

    default AbstractAnimal choiceAnimal(int type){
        return null;
    }

    default AbstractAnimal createAnimal(){ return null;}

    default Map<String, List<AbstractAnimal>> createMasAnimal(){
        return null;
    }
}
