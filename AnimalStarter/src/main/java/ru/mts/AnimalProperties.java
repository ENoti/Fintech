package ru.mts;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
public class AnimalProperties {

    private String[] animalName;

    public void setAnimalName(String[] animalName) {
        this.animalName = animalName;
    }

    public String getNameAnimal() {
        int rand = (int) (Math.random() * 5);
        return animalName[rand];
    }

    public String chooseNameAnimal(int cnt) {
        return animalName[cnt];
    }

    public int countName(){
        return animalName.length;
    }

}
