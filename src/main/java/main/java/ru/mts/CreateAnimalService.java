package main.java.ru.mts;

public interface CreateAnimalService {
    default void createAnimal(){
        int rand = (int) (Math.random() * 2);
        AbstractAnimal animal;
        if(rand == 0){
            rand = (int) (Math.random() * 2);
            if(rand == 0)
                animal = new Cat();
            else
                animal = new Dog();
            print(animal);
        }
        else{
            rand = (int) (Math.random() * 2);
            if(rand == 0)
                animal = new Shark();
            else
                animal = new Wolf();
            print(animal);
        }
    }
    default void printAnimal(){
        int N = 10;
        while (N != 0) {
            createAnimal();
            N--;
        }
    }
    default void print(AbstractAnimal abstractAnimal){
        System.out.println("Порода: " + abstractAnimal.getBreed());
        System.out.println("Кличка: " + abstractAnimal.getName());
        System.out.println("Характер: " + abstractAnimal.getCharacter());
        System.out.println("Цена в магазине: " + abstractAnimal.getCost() + "\n");
    }
}
