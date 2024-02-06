package ru.mts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Component
public class AnimalsRepositoryImpl implements AnimalsRepository {

    ApplicationContext context = new AnnotationConfigApplicationContext(CreateConfiguration.class);

    AbstractAnimal[] arrayAnimals;
    @PostConstruct
    public void postConstruct(){
        arrayAnimals = context.getBean(CreateAnimalService.class).createMasAnimal();
    }

    public ArrayList<String> findLeapYearNames() {
        ArrayList<String> arrayLeapYear = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() % 400 == 0 ||
                    arrayAnimal.birthDate.getYear() % 4 == 0 && arrayAnimal.birthDate.getYear() % 100 != 0) {
                arrayLeapYear.add(arrayAnimal.name);
            }
        }
        return arrayLeapYear;
    }
    public ArrayList<AbstractAnimal> findOlderAnimal(int N) {
        ArrayList<AbstractAnimal> arrayOldAnimals = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() > N)
                arrayOldAnimals.add(arrayAnimal);
        }
        return arrayOldAnimals;
    }

    public Boolean findDuplicate() {
        for (int i = 0; i < arrayAnimals.length; i++) {
            for (int j = i + 1; j < arrayAnimals.length; j++) {
                if (arrayAnimals[i].equals(arrayAnimals[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
