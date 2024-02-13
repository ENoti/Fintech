package ru.mts;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Animal {
    default String getBreed() {
        return null;
    }

    default String getName() {
        return null;
    }

    default BigDecimal getCost() {
        return null;
    }

    default String getCharacter() {
        return null;
    }

    default LocalDate getBirthDate(){
        return null;
    }
}
