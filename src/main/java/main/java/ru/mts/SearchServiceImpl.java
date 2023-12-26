package main.java.ru.mts;

import java.util.ArrayList;

public class SearchServiceImpl implements SearchService{
    public ArrayList<String> findLeapYearNames(AbstractAnimal[] arrayAnimals){
        ArrayList<String> arrayLeapYear = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() % 400 == 0 ||
                    arrayAnimal.birthDate.getYear() % 4 == 0 && arrayAnimal.birthDate.getYear() % 100 != 0) {
                arrayLeapYear.add(arrayAnimal.name);
            }
        }
        return arrayLeapYear;
    }
    public ArrayList<AbstractAnimal> findOlderAnimal(AbstractAnimal[] arrayAnimals, int N){
        ArrayList<AbstractAnimal> arrayOldAnimals = new ArrayList<>();
        for (AbstractAnimal arrayAnimal : arrayAnimals) {
            if (arrayAnimal.birthDate.getYear() > N)
                arrayOldAnimals.add(arrayAnimal);
        }
        return arrayOldAnimals;
    }
    public void findDuplicate(AbstractAnimal[] arrayAnimals){
        for (int i = 0; i < arrayAnimals.length; i++) {
            for (int j = i+1; j < arrayAnimals.length; j++) {
                if (arrayAnimals[i].equals(arrayAnimals[j])) {
                    System.out.println(arrayAnimals[i]);
                }
            }
        }
    }
}
