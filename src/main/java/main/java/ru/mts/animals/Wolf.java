package main.java.ru.mts.animals;

import main.java.ru.mts.Predator;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Wolf extends Predator {
    @Override
    public String getBreed() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Красный");
        breed.add("Полярый");
        breed.add("Восточный");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    @Override
    public String getName() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Вулф");
        breed.add("Ауф");
        breed.add("Уффф");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    @Override
    public BigDecimal getCost() {
        LinkedList<BigDecimal> breed = new LinkedList<>();
        breed.add(BigDecimal.valueOf(40000));
        breed.add(BigDecimal.valueOf(20000));
        breed.add(BigDecimal.valueOf(100000));
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    public Wolf() {
        name = getName();
        cost = getCost();
        breed = getBreed();
        character = getCharacter();
        birthDate = getBirthDate();
    }
}
