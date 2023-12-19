package main.java.ru.mts;

import java.math.BigDecimal;

public interface Animal {
    default String getBreed(){
        return null;
    };
    default String getName() {
        return null;
    }
    default BigDecimal getCost() {
        return null;
    }
    default String getCharacter() {
        return null;
    }
}
