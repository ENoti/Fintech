package main.java.ru.mts.animals;

import main.java.ru.mts.Pet;
import java.math.BigDecimal;
import java.util.LinkedList;

public class Cat extends Pet {
    @Override
    public String getBreed() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Мейн-кун");
        breed.add("Шотландец");
        breed.add("Британец");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    @Override
    public String getName() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Фродо");
        breed.add("Рыжий");
        breed.add("Леопольд");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    @Override
    public BigDecimal getCost() {
        LinkedList<BigDecimal> breed = new LinkedList<>();
        breed.add(BigDecimal.valueOf(50000));
        breed.add(BigDecimal.valueOf(10000));
        breed.add(BigDecimal.valueOf(200000));
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }

    public Cat() {
        name = getName();
        breed = getBreed();
        cost = getCost();
        character = getCharacter();
        birthDate = getBirthDate();
    }
}
