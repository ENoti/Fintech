package ru.mts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class Application{

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfiguration.class);

        ArrayList<String> resultLeapYears = context.getBean(AnimalsRepository.class).findLeapYearNames();
        System.out.println("Имена животных, которые родились в високосный год:");
        for (String result : resultLeapYears)
            System.out.println(result);

        int N = 2014;
        ArrayList<AbstractAnimal> resultOld = context.getBean(AnimalsRepository.class).findOlderAnimal(N);
        System.out.println("\nЖивотные, дата рождения которых больше " + N + ":");
        for (AbstractAnimal result : resultOld)
            System.out.println(result);

        System.out.println("\nДубликаты:");
        System.out.println(context.getBean(AnimalsRepository.class).findDuplicate());


    }
}