package ru.mts;

import ru.mts.AbstractAnimal;
import ru.mts.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Shark extends Predator {

    public Shark(){
        List<String> breed = Arrays.asList("Китовая", "Лисья", "Усатая");
        int rand = (int) (Math.random() * 3);
        this.breed = breed.get(rand);
        List<String> name = Arrays.asList("Клык", "Шпик", "Рыг");
        rand = (int) (Math.random() * 3);
        this.name = name.get(rand);
        List<Integer> cost = Arrays.asList(500000, 100000, 2000000);
        rand = (int) (Math.random() * 3);
        this.cost = BigDecimal.valueOf(cost.get(rand));
        this.birthDate = getBirthDateGen();
        this.character = getCharacterGen();
    }
    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCharacter() {
        return character;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.getBreed()) && Objects.equals(name, that.getName()) &&
                Objects.equals(cost, that.getCost()) && Objects.equals(character, that.getCharacter())
                && Objects.equals(birthDate, that.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }
}
