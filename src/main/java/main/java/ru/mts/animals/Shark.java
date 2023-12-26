package main.java.ru.mts.animals;

import main.java.ru.mts.Predator;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Shark extends Predator {
    @Override
    public String getBreed() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Китовая");
        breed.add("Лисья");
        breed.add("Усатая");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    @Override
    public String getName() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Клык");
        breed.add("Шпик");
        breed.add("Рыг");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }

    @Override
    public BigDecimal getCost() {
        LinkedList<BigDecimal> breed = new LinkedList<>();
        breed.add(BigDecimal.valueOf(500000));
        breed.add(BigDecimal.valueOf(100000));
        breed.add(BigDecimal.valueOf(2000000));
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }

    public Shark() {
        name = getName();
        breed = getBreed();
        cost = getCost();
        character = getCharacter();
        birthDate = getBirthDate();
    }
}
