package ru.mts.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;


public abstract class AbstractAnimal implements Animal {

    public String breed; //порода
    public String name; //имя
    public BigDecimal cost; //цена в магазине, до двух знаков после запятой
    public String character; //характер
    public LocalDate birthDate; //день рождения животного в формате dd-MM-yyyy

    public LocalDate getBirthDateGen() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
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

    public AbstractAnimal choiceAnimal(int type) {
        AbstractAnimal abstractAnimal = null;
        switch (type) {
            case 0: {
                abstractAnimal = new Dog();
                break;
            }
            case 1: {
                abstractAnimal = new Cat();
                break;
            }
            case 2: {
                abstractAnimal = new Wolf();
                break;
            }
            case 3: {
                abstractAnimal = new Shark();
                break;
            }
        }
        return abstractAnimal;
    }

    public static <T> T getAnimal(Object object) {
        return (T) object;
    }

    public abstract boolean equals(Object o);
    public abstract int hashCode();
}
