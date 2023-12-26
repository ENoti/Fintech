package main.java.ru.mts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractAnimal implements Animal {
    protected String breed; //порода
    protected String name; //имя
    protected BigDecimal cost; //цена в магазине, до двух знаков после запятой
    protected String character; //характер
    protected LocalDate birthDate; //день рождения животного в формате dd-MM-yyyy

    @Override
    public LocalDate getBirthDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost) && Objects.equals(character, that.character) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" + '\n' +
                "Breed = " + breed + '\n' +
                "Name = " + name + '\n' +
                "Cost = " + cost + '\n' +
                "Character = " + character + '\n' +
                "Date = " + birthDate + '\n' +
                "}\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }
}
