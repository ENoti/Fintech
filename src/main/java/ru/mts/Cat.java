package ru.mts;

import ru.mts.AbstractAnimal;
import ru.mts.Pet;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cat extends Pet {

    public Cat(){
        List<String> breed = Arrays.asList("Мейн-кун", "Шотландец", "Британец");
        int rand = (int) (Math.random() * 3);
        this.breed = breed.get(rand);
        List<String> name = Arrays.asList("Фродо", "Рыжий", "Леопольд");
        rand = (int) (Math.random() * 3);
        this.name = name.get(rand);
        List<Integer> cost = Arrays.asList(50000, 10000, 200000);
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
