package main.java.ru.mts;

import java.math.BigDecimal;
import java.util.LinkedList;

public abstract class Predator extends AbstractAnimal {
    @Override
    public String getCharacter() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Злой");
        breed.add("Жестокий");
        breed.add("Кровожадный");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }

    public void nameClass(){
        System.out.println("Predator");
    }
}
