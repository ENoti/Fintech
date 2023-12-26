package main.java.ru.mts;

import java.util.ArrayList;

public class Main{

    public static void main(String[] args){
        AbstractAnimal[] abstractAnimals = new CreateAnimalServiceImpl().createAnimal(10);

        ArrayList<String> resultLeapYears = new SearchServiceImpl().findLeapYearNames(abstractAnimals);
        System.out.println("имена животных, которые родились в високосный год:");
        for (String result : resultLeapYears)
            System.out.println(result);

        int N = 2014;
        ArrayList<AbstractAnimal> resultOld = new SearchServiceImpl().findOlderAnimal(abstractAnimals, N);
        System.out.println("\nЖивотные, дата рождения которых больше " + N + ":");
        for (AbstractAnimal result : resultOld)
            System.out.println(result);

        System.out.println("\nДубликаты:");
        new SearchServiceImpl().findDuplicate(abstractAnimals);
    }
}