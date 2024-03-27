package ru.mts.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.entity.AbstractAnimal;
import ru.mts.exception.NotEnoughSizeException;
import ru.mts.exception.UnrealArgumentException;
import ru.mts.service.CreateAnimalServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Year;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Autowired
    CreateAnimalServiceImpl createAnimalService;

    ConcurrentMap<String, CopyOnWriteArrayList<AbstractAnimal>> arrayAnimals;

    @PostConstruct
    public void postConstruct(){
        arrayAnimals = createAnimalService.createMasAnimal();
    }

    @Scheduled(fixedDelay = 60000)
    public ConcurrentMap<String, LocalDate> findLeapYearNames() {
        ConcurrentMap<String, LocalDate> map = null;
        try {
            map = arrayAnimals.entrySet().stream()
                    .flatMap(entry -> entry.getValue().stream())
                    .filter(abstractAnimal -> abstractAnimal.birthDate.getYear() % 400==0 ||
                            abstractAnimal.birthDate.getYear() % 4 == 0 && abstractAnimal.birthDate.getYear() % 100 != 0)
                    .collect(Collectors.toConcurrentMap(abstractAnimal -> abstractAnimal.getClass().getSimpleName() + " " +
                            abstractAnimal.name, abstractAnimal -> abstractAnimal.birthDate));
            System.out.println(map);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return map;
    }

    public ConcurrentMap<AbstractAnimal, Integer> findOlderAnimal(int N){

        ConcurrentMap<AbstractAnimal, Integer> map = null;
        try {
            if (N <= 0) {
                throw new UnrealArgumentException("Invalid argument: N cannot be less than 0");
            } else if ( N > Year.now().getValue()){
                throw new UnrealArgumentException("Invalid argument: N cannot be less than " +  Year.now().getValue());
            }
            var ref = new Object() {
                int maxOld = Year.now().getValue();
                AbstractAnimal abstractAnimalOld = null;
            };
            map = arrayAnimals.values().stream()
                    .flatMap(List::stream)
                    .filter(abstractAnimal -> abstractAnimal.birthDate.getYear() >= N)
                    .collect(Collectors.toMap(Function.identity(), abstractAnimal -> Year.now().getValue() - abstractAnimal.birthDate.getYear(),
                            (oldAnimal, newAnimal) -> oldAnimal, HashMap::new))
                    .entrySet().stream()
                    .peek(entry -> {
                        int year = entry.getKey().birthDate.getYear();
                        if (ref.maxOld > 0 && year < ref.maxOld) {
                            ref.maxOld = year;
                            ref.abstractAnimalOld = entry.getKey();
                        }
                    })
                    .collect(Collectors.toConcurrentMap(ConcurrentMap.Entry::getKey, ConcurrentMap.Entry::getValue));
            if(map.isEmpty()) {
                map.put(ref.abstractAnimalOld, 2024 - ref.maxOld);
                return map;
            }
        } catch (UnrealArgumentException e){
            System.out.println(e.getMessage());
        }
        return map;
    }

    @Scheduled(fixedDelay = 60000)
    public ConcurrentMap<String, Integer> findDuplicateTrue() {
        ConcurrentMap<String, Integer> map = null;
        try {
            map = arrayAnimals.values().stream()
                    .flatMap(List::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .collect(Collectors.toConcurrentMap(abstractAnimalLongEntry -> abstractAnimalLongEntry.getKey().
                            getClass().getSimpleName(), entry -> entry.getValue().intValue()));
            System.out.println(map);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return map;
    }

    @Scheduled(fixedDelay = 60000)
    public ConcurrentMap<String, Integer> findDuplicateFalse() {
        ConcurrentMap<String, Integer> map = null;
        try{
            ConcurrentMap<String, CopyOnWriteArrayList<AbstractAnimal>> arrayAnimals2 = createAnimalService.createMasAnimal(10);
            map = arrayAnimals2.values().stream()
                    .flatMap(List::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() > 1)
                    .collect(Collectors.toConcurrentMap(abstractAnimalLongEntry -> abstractAnimalLongEntry.getKey().
                            getClass().getSimpleName(), entry -> entry.getValue().intValue()));
            System.out.println(map);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return map;
    }

    public double findAverageAge(){
        return arrayAnimals.values().stream()
                .flatMap(List::stream)
                .mapToDouble(abstractAnimal -> abstractAnimal.birthDate.getYear())
                .average()
                .orElse(0.0);
    }
    public CopyOnWriteArrayList<AbstractAnimal> findOldAndExpensive(){
        double middleCost = arrayAnimals.values().stream()
                .flatMap(CopyOnWriteArrayList::stream)
                .mapToDouble(abstractAnimal -> abstractAnimal.cost.intValue())
                .average()
                .orElse(0.0);
        return (CopyOnWriteArrayList<AbstractAnimal>) arrayAnimals.values().stream()
                .flatMap(CopyOnWriteArrayList::stream)
                .filter(abstractAnimal -> (2024 - abstractAnimal.birthDate.getYear() > 5)
                        && (abstractAnimal.cost.doubleValue() > middleCost))
                .collect(Collectors.toList());
    }

    public CopyOnWriteArrayList<String> findMinConstAnimals(){
        CopyOnWriteArrayList<String> arrayAnimalsLocal = new CopyOnWriteArrayList<>();
        if (arrayAnimals.size() < 3) {
            throw new NotEnoughSizeException("There must be at least 3 animals");
        }
        try {
            arrayAnimalsLocal.addAll(arrayAnimals.values().stream()
                    .flatMap(List::stream)
                    .sorted(new AnimalComparator())
                    .limit(3)
                    .map(AbstractAnimal::getName)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return arrayAnimalsLocal;
    }

    public CopyOnWriteArrayList<String> findMinConstAnimals(ConcurrentMap<String, CopyOnWriteArrayList<AbstractAnimal>> arrayAnimals){
        CopyOnWriteArrayList<String> arrayAnimalsLocal = new CopyOnWriteArrayList<>();
        if (arrayAnimals.values().stream().mapToLong(List::size).sum() < 3) {
            throw new IllegalArgumentException("There must be at least 3 animals");
        }
        try {
            arrayAnimalsLocal.addAll(arrayAnimals.values().stream()
                    .flatMap(List::stream)
                    .sorted(new AnimalComparator())
                    .limit(3)
                    .map(AbstractAnimal::getName)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return arrayAnimalsLocal;
    }

    static class AnimalComparator implements Comparator<AbstractAnimal>{
        public int compare(AbstractAnimal a, AbstractAnimal b){
            return a.cost.compareTo(b.cost);
        }
    }
}
