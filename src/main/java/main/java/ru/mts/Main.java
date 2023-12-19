package main.java.ru.mts;
public class Main{

    public static void main(String[] args){
        new CreateAnimalServiceImpl().printAnimal();
        new CreateAnimalServiceImpl().printAnimal(10);

    }
}