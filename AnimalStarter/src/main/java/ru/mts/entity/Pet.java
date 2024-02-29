package ru.mts.entity;

import java.util.LinkedList;

public abstract class Pet extends AbstractAnimal{

    public String getCharacterGen() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Добрый");
        breed.add("Милый");
        breed.add("Любящий");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
}
