package ru.mts;

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

    public ArrayList<AbstractAnimal> findDuplicate(AbstractAnimal[] arrayAnimals){
        ArrayList<AbstractAnimal> arrayFindDuplicates = new ArrayList<>();
        for (int i = 0; i < arrayAnimals.length; i++) {
            for (int j = i+1; j < arrayAnimals.length; j++) {
                if (arrayAnimals[i].equals(arrayAnimals[j])) {
                    arrayFindDuplicates.add(arrayAnimals[i]);
                }
            }
        }
        return arrayFindDuplicates;
    }

    public void printDuplicate(AbstractAnimal[] arrayAnimals){
        System.out.println(findDuplicate(arrayAnimals));
    }
}
