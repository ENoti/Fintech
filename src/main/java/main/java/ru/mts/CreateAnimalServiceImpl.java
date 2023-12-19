package main.java.ru.mts;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void printAnimal(int N){
        for (int i = 0; i < N; i++) {
            createAnimal();
        }
    }
    public void printAnimal(){
        int N = 10;
        do{
            createAnimal();
            N--;
        }while (N!=0);
    }
}
