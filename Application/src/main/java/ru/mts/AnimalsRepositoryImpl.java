package ru.mts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Component
public class AnimalsRepositoryImpl implements AnimalsRepository {
    @Autowired
    private AppConfiguration appConfiguration;

    AbstractAnimal[] arrayAnimals;

    @PostConstruct
    public void postConstruct(){
        arrayAnimals = appConfiguration.createMasAnimal();
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
        System.out.println("Имена животных, которые родились в високосный год:");
        for (String result : arrayLeapYear)
            System.out.println(result);

    }

    public void findOlderAnimal(int N) {
        ArrayList<AbstractAnimal> arrayOldAnimals = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() > N)
                arrayOldAnimals.add(arrayAnimal);
        }
        System.out.println("\nЖивотные, дата рождения которых больше " + N + ":");
        for (AbstractAnimal result : arrayOldAnimals)
            System.out.println(result);
    }

    @Scheduled(fixedDelay = 60000)
    public boolean findDuplicateTrue() {
        System.out.println("\nДубликаты:");
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
        AbstractAnimal[] arrayAnimals2 = appConfiguration.createMasAnimal(10);
        System.out.println("\nДубликаты:");
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
