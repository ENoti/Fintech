package ru.mts;

import org.springframework.beans.BeansException;

public interface CreateAnimalService {

    default AbstractAnimal choiceAnimal(int type){
        return null;
    }

    default AbstractAnimal createAnimal(){
        return null;
    }

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    default AbstractAnimal[] createMasAnimal(){
        return null;
    }
}
