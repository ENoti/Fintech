package ru.mts;

public interface CreateAnimalService {
    default AbstractAnimal choiceAnimal(int type){
        AbstractAnimal animal = switch (type) {
            case 0 -> new Dog();
            case 1 -> new Cat();
            case 2 -> new Wolf();
            case 3 -> new Shark();
            default -> null;
        };
        return animal;
    }
    default AbstractAnimal[] createAnimal(){
        int N = 10;
        AbstractAnimal[] arrayAnimal = new AbstractAnimal[N];
        while (N != 0) {
            int rand = (int) (Math.random() * 4);
            arrayAnimal[arrayAnimal.length-N] = choiceAnimal(rand);
            N--;
        }
        return arrayAnimal;
    }
}
