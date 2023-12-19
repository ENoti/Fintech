package main.java.ru.mts;

import java.math.BigDecimal;
import java.util.LinkedList;

public class Wolf extends Predator{
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
        breed.add(BigDecimal.valueOf(400000));
        breed.add(BigDecimal.valueOf(200000));
        breed.add(BigDecimal.valueOf(1000000));
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    public Wolf() {
        this.nameClass();
        name = getName();
        breed = getBreed();
        character = getCharacter();
    }
}
