package ru.mts;

public interface CreateAnimalService {

    default AbstractAnimal choiceAnimal(int type){
        return null;
    }

    default AbstractAnimal createAnimal(){ return null;}

    default AbstractAnimal[] createMasAnimal(){
        return null;
    }
}
