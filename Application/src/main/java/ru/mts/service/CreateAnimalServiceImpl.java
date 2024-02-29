package ru.mts.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mts.config.AppConfiguration;
import ru.mts.entity.*;
import ru.mts.config.AnimalProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Autowired
    AnimalProperties animalProperties;

    @Autowired
    AppConfiguration appConfiguration;

    public AbstractAnimal choiceAnimal(int type) {
        AbstractAnimal abstractAnimal = null;
        switch (type) {
            case 0: {
                abstractAnimal = new Dog();
                break;
            }
            case 1: {
                abstractAnimal = new Cat();
                break;
            }
            case 2: {
                abstractAnimal = new Wolf();
                break;
            }
            case 3: {
                abstractAnimal = new Shark();
                break;
            }
        }
        return abstractAnimal;
    }

    public List<AbstractAnimal> testSearch(List<AbstractAnimal> abstractAnimals){
        abstractAnimals.add(choiceAnimal(0));
        abstractAnimals.get(0).name = "TestName";
        abstractAnimals.get(0).cost = BigDecimal.valueOf(0);
        abstractAnimals.get(0).birthDate = LocalDate.parse("2002-06-28");
        abstractAnimals.get(0).breed = "Королевский род";
        abstractAnimals.get(0).character = "Норм чел";
        abstractAnimals.add(choiceAnimal(0));
        abstractAnimals.get(1).name = "TestName";
        abstractAnimals.get(1).cost = BigDecimal.valueOf(0);
        abstractAnimals.get(1).birthDate = LocalDate.parse("2002-06-28");
        abstractAnimals.get(1).breed = "Королевский род";
        abstractAnimals.get(1).character = "Норм чел";
        return abstractAnimals;
    }

    public Map<String, List<AbstractAnimal>> createMasAnimal(int N) {
        Map<String, List<AbstractAnimal>> arrayAnimal = new HashMap<>();
        List<AbstractAnimal> cats = new ArrayList<>();
        List<AbstractAnimal> dogs = new ArrayList<>();
        List<AbstractAnimal> sharks = new ArrayList<>();
        List<AbstractAnimal> wolves = new ArrayList<>();
        dogs = testSearch(dogs);
        arrayAnimal.put((choiceAnimal(0).getClass().getSimpleName()), AbstractAnimal.getAnimal(dogs));
        N -= 2;
        while (N != 0) {
            AbstractAnimal abstractAnimal = appConfiguration.createAnimal();
            if(abstractAnimal instanceof Cat) {
                cats.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(cats));
                arrayAnimal.get((cats.get(cats.size()-1).getClass().getSimpleName())).get(cats.size()-1).name
                        = animalProperties.getNameAnimal();
            }
            else if (abstractAnimal instanceof Dog) {
                dogs.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(dogs));
                arrayAnimal.get((dogs.get(dogs.size()-1).getClass().getSimpleName())).get(dogs.size()-1).name
                        = animalProperties.getNameAnimal();
            } else if (abstractAnimal instanceof Wolf) {
                wolves.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(wolves));
                arrayAnimal.get((wolves.get(wolves.size()-1).getClass().getSimpleName())).get(wolves.size()-1).name
                        = animalProperties.getNameAnimal();
            }
            else if (abstractAnimal instanceof Shark) {
                sharks.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(sharks));
                arrayAnimal.get((sharks.get(sharks.size()-1).getClass().getSimpleName())).get(sharks.size()-1).name
                        = animalProperties.getNameAnimal();
            }
            N--;
        }
        return arrayAnimal;
    }

    public Map<String, List<AbstractAnimal>> createMasAnimal() {
        int N = 0;
        Map<String, List<AbstractAnimal>> arrayAnimal = new HashMap<>();
        List<AbstractAnimal> cats = new ArrayList<>();
        List<AbstractAnimal> dogs = new ArrayList<>();
        List<AbstractAnimal> sharks = new ArrayList<>();
        List<AbstractAnimal> wolves = new ArrayList<>();
        do{
            AbstractAnimal abstractAnimal = appConfiguration.createAnimal();
            if(abstractAnimal instanceof Cat) {
                cats.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(cats));
                arrayAnimal.get((cats.get(cats.size()-1).getClass().getSimpleName())).get(cats.size()-1).name
                        = animalProperties.getNameAnimal();
            }
            else if (abstractAnimal instanceof Dog) {
                dogs.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(dogs));
                arrayAnimal.get((dogs.get(dogs.size()-1).getClass().getSimpleName())).get(dogs.size()-1).name
                        = animalProperties.getNameAnimal();
            } else if (abstractAnimal instanceof Wolf) {
                wolves.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(wolves));
                arrayAnimal.get((wolves.get(wolves.size()-1).getClass().getSimpleName())).get(wolves.size()-1).name
                        = animalProperties.getNameAnimal();
            }
            else if (abstractAnimal instanceof Shark) {
                sharks.add(AbstractAnimal.getAnimal(abstractAnimal));
                arrayAnimal.put((abstractAnimal.getClass().getSimpleName()), AbstractAnimal.getAnimal(sharks));
                arrayAnimal.get((sharks.get(sharks.size()-1).getClass().getSimpleName())).get(sharks.size()-1).name
                        = animalProperties.getNameAnimal();
            }
            N++;
        }while (N!=10);
        return arrayAnimal;
    }
}
