package ru.mts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Component
public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Autowired
    CreateAnimalServiceImpl createAnimalService;

    AbstractAnimal[] arrayAnimals;

    @PostConstruct
    public void postConstruct(){
        arrayAnimals = createAnimalService.createMasAnimal();
    }

    @Scheduled(fixedDelay = 60000)
    public void findLeapYearNames() {
        ArrayList<String> arrayLeapYear = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() % 400 == 0 ||
                    arrayAnimal.birthDate.getYear() % 4 == 0 && arrayAnimal.birthDate.getYear() % 100 != 0) {
                arrayLeapYear.add(arrayAnimal.name);
            }
        }
        for (String result : arrayLeapYear)
            System.out.println(result);

    }

    public void findOlderAnimal(int N) {
        ArrayList<AbstractAnimal> arrayOldAnimals = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() > N)
                arrayOldAnimals.add(arrayAnimal);
        }
        for (AbstractAnimal result : arrayOldAnimals)
            System.out.println(result);
    }

    @Scheduled(fixedDelay = 60000)
    public boolean findDuplicateTrue() {
        for (int i = 0; i < arrayAnimals.length; i++) {
            for (int j = i + 1; j < arrayAnimals.length; j++) {
                if (arrayAnimals[i].equals(arrayAnimals[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Scheduled(fixedDelay = 60000)
    public boolean findDuplicateFalse() {
        AbstractAnimal[] arrayAnimals2 = createAnimalService.createMasAnimal(10);
        for (int i = 0; i < arrayAnimals2.length; i++) {
            for (int j = i + 1; j < arrayAnimals2.length; j++) {
                if (arrayAnimals2[i].equals(arrayAnimals2[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
