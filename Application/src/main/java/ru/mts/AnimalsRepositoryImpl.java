package ru.mts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Autowired
    CreateAnimalServiceImpl createAnimalService;

    Map<String, List<AbstractAnimal>> arrayAnimals;

    @PostConstruct
    public void postConstruct(){
        arrayAnimals = createAnimalService.createMasAnimal();
    }

    @Scheduled(fixedDelay = 60000)
    public Map<String, LocalDate> findLeapYearNames() {
        Map<String, LocalDate> arrayLeapYear = new HashMap<>();
        for (String key: arrayAnimals.keySet()) {
            for (AbstractAnimal abstractAnimal : arrayAnimals.get(key)) {
                if (abstractAnimal.birthDate.getYear() % 400 == 0 || abstractAnimal.birthDate.getYear() % 4 == 0 &&
                        abstractAnimal.birthDate.getYear() % 100 != 0) {
                    arrayLeapYear.put(abstractAnimal.getClass().getSimpleName() + " "
                            + abstractAnimal.name, abstractAnimal.birthDate);
                }
            }
        }
        System.out.println(arrayLeapYear);
        return arrayLeapYear;
    }

    public Map<AbstractAnimal, Integer> findOlderAnimal(int N) {
        int maxOld = 5000;
        AbstractAnimal abstractAnimalOld = null;
        Map<AbstractAnimal, Integer> arrayOldAnimals = new HashMap<>();
        for (String key: arrayAnimals.keySet()) {
            for(AbstractAnimal abstractAnimal: arrayAnimals.get(key)) {
                if (abstractAnimal.birthDate.getYear() > N) {
                    arrayOldAnimals.put(abstractAnimal, 2024 - abstractAnimal.birthDate.getYear());
                } else if (maxOld > 0) {
                    System.out.println(Integer.parseInt(String.valueOf(abstractAnimal.birthDate.getYear())));
                    maxOld = abstractAnimal.birthDate.getYear();
                    abstractAnimalOld = abstractAnimal;
                }
            }
        }
        if(arrayOldAnimals.isEmpty()) {
            arrayOldAnimals.put(abstractAnimalOld, 2024 - maxOld);
            return arrayOldAnimals;
        }
        System.out.println(arrayOldAnimals);
        return arrayOldAnimals;
    }

    @Scheduled(fixedDelay = 60000)
    public Map<String, Integer> findDuplicateTrue() {
        Map<String, Integer> duplicate = new HashMap<>();
        for (String key: arrayAnimals.keySet()) {
            for (int i = 0; i < arrayAnimals.get(key).size(); i++) {
                for (int j = i + 1; j < arrayAnimals.get(key).size(); j++) {
                    if (arrayAnimals.get(key).get(i).equals(arrayAnimals.get(key).get(j))) {
                        duplicate.put(key, duplicate.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
        System.out.println(duplicate);
        return duplicate;
    }

    @Scheduled(fixedDelay = 60000)
    public Map<String, Integer> findDuplicateFalse() {
        Map<String, List<AbstractAnimal>> arrayAnimals2 = createAnimalService.createMasAnimal(10);
        Map<String, Integer> duplicate = new HashMap<>();
        for (String key: arrayAnimals2.keySet()) {
            for (int i = 0; i < arrayAnimals2.get(key).size(); i++) {
                for (int j = i + 1; j < arrayAnimals2.get(key).size(); j++) {
                    if (arrayAnimals2.get(key).get(i).equals(arrayAnimals2.get(key).get(j))) {
                        duplicate.put(key, duplicate.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }
        System.out.println(duplicate);
        return duplicate;
    }
}
