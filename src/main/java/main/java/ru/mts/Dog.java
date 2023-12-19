package main.java.ru.mts;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Dog extends Pet{

    @Override
    public String getBreed() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Овчарка");
        breed.add("Чихуа-хуа");
        breed.add("Шпиц");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    @Override
    public String getName() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Сосиска");
        breed.add("Джордж");
        breed.add("Тарзан");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    @Override
    public BigDecimal getCost() {
        LinkedList<BigDecimal> breed = new LinkedList<>();
        breed.add(BigDecimal.valueOf(70000));
        breed.add(BigDecimal.valueOf(15000));
        breed.add(BigDecimal.valueOf(20200));
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }

    public Dog() {
        this.nameClass();
        name = getName();
        breed = getBreed();
        cost = getCost();
        character = getCharacter();
    }
}
