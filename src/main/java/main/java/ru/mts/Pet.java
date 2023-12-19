package main.java.ru.mts;

import java.math.BigDecimal;
import java.util.LinkedList;

public abstract class Pet extends AbstractAnimal{
    @Override
    public String getCharacter() {
        LinkedList<String> breed = new LinkedList<>();
        breed.add("Добрый");
        breed.add("Милый");
        breed.add("Любящий");
        int rand = (int) (Math.random() * 3);
        return breed.get(rand);
    }
    public void nameClass(){
        System.out.println("Pet");
    }
}
