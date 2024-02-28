package ru.mts;

import java.util.LinkedList;

public abstract class Predator extends AbstractAnimal {

    public String getCharacterGen() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Злой");
        breed.add("Кровожадный");
        breed.add("Жестокий");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
}
