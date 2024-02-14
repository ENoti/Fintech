package ru.mts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Component
public class AnimalsRepositoryImpl implements AnimalsRepository {
    @Autowired
    private CreateConfiguration createConfiguration;

    AbstractAnimal[] arrayAnimals;

    @PostConstruct
    public void postConstruct(){
        arrayAnimals = createConfiguration.createMasAnimal();
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

    @Scheduled(fixedDelay = 60000)
    public void findOlderAnimal() {
        int N = 2015;
        ArrayList<AbstractAnimal> arrayOldAnimals = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() > N)
                arrayOldAnimals.add(arrayAnimal);
        }
        System.out.println("\nЖивотные, дата рождения которых больше " + N + ":");
        for (AbstractAnimal result : arrayOldAnimals)
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
    public void findDuplicate() {
        System.out.println("\nДубликаты:");
        for (int i = 0; i < arrayAnimals.length; i++) {
            for (int j = i + 1; j < arrayAnimals.length; j++) {
                if (arrayAnimals[i].equals(arrayAnimals[j])) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }
}
