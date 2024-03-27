package ru.mts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import ru.mts.config.AppConfiguration;
import ru.mts.entity.*;
import ru.mts.repository.AnimalsRepositoryImpl;
import ru.mts.service.CreateAnimalServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

@SpringBootTest(classes = AppConfiguration.class)
class SearchServiceTest {

    @Nested
    class AnimalEqualsTest {
        @DisplayName("Test Equals Dog")
        @Test
        void testEqualsDog() {
            Dog animal1 = new Dog();
            animal1.name = "TestName";
            animal1.cost = BigDecimal.valueOf(0);
            animal1.birthDate = LocalDate.parse("2002-06-28");
            animal1.breed = "TestBreed";
            animal1.character = "TestCharacter";
            Dog animal2 = animal1;
            Assertions.assertEquals(animal1, animal2);
            animal2 = new Dog();
            animal2.name = "TestName2";
            animal2.cost = BigDecimal.valueOf(0);
            animal2.birthDate = LocalDate.parse("2002-06-26");
            animal2.breed = "TestBreed2";
            animal2.character = "TestCharacter2";
            Assertions.assertNotEquals(animal1, animal2);
        }
        @DisplayName("Test Equals Cat")
        @Test
        void testEqualsCat() {
            Cat animal1 = new Cat();
            animal1.name = "TestName";
            animal1.cost = BigDecimal.valueOf(0);
            animal1.birthDate = LocalDate.parse("2002-06-28");
            animal1.breed = "TestBreed";
            animal1.character = "TestCharacter";
            Cat animal2 = animal1;
            Assertions.assertEquals(animal1, animal2);
            animal2 = new Cat();
            animal2.name = "TestName2";
            animal2.cost = BigDecimal.valueOf(0);
            animal2.birthDate = LocalDate.parse("2002-06-26");
            animal2.breed = "TestBreed2";
            animal2.character = "TestCharacter2";
            Assertions.assertNotEquals(animal1, animal2);
        }
        @DisplayName("Test Equals Wolf")
        @Test
        void testEqualsWolf() {
            Wolf animal1 = new Wolf();
            animal1.name = "TestName";
            animal1.cost = BigDecimal.valueOf(0);
            animal1.birthDate = LocalDate.parse("2002-06-28");
            animal1.breed = "TestBreed";
            animal1.character = "TestCharacter";
            Wolf animal2 = animal1;
            Assertions.assertEquals(animal1, animal2);
            animal2 = new Wolf();
            animal2.name = "TestName2";
            animal2.cost = BigDecimal.valueOf(0);
            animal2.birthDate = LocalDate.parse("2002-06-26");
            animal2.breed = "TestBreed2";
            animal2.character = "TestCharacter2";
            Assertions.assertNotEquals(animal1, animal2);
        }
        @DisplayName("Test Equals Shark")
        @Test
        void testEqualsShark() {
            Shark animal1 = new Shark();
            animal1.name = "TestName";
            animal1.cost = BigDecimal.valueOf(0);
            animal1.birthDate = LocalDate.parse("2002-06-28");
            animal1.breed = "TestBreed";
            animal1.character = "TestCharacter";
            Shark animal2 = animal1;
            Assertions.assertEquals(animal1, animal2);
            animal2 = new Shark();
            animal2.name = "TestName2";
            animal2.cost = BigDecimal.valueOf(0);
            animal2.birthDate = LocalDate.parse("2002-06-26");
            animal2.breed = "TestBreed2";
            animal2.character = "TestCharacter2";
            Assertions.assertNotEquals(animal1, animal2);
        }
    }
    @Nested
    class SearchServiceImplTest{

        @Autowired
        AnimalsRepositoryImpl animalsRepository;

        @DisplayName("findLeapYearNames Test")
        @Test
        void findLeapYearNamesTest(){
            System.out.println("========TEST ONE EXECUTED=======");
            System.out.println("Имена животных, которые родились в високосный год:");
            animalsRepository.findLeapYearNames();
        }
        @DisplayName("findOlderAnimal Test")
        @ParameterizedTest
        @ValueSource(ints = {2016,2017,2021,2019,2015,2020})
        void findOlderAnimalTest(int number){
            System.out.println("========TEST TWO EXECUTED=======");
            System.out.println("\nЖивотные, дата рождения которых больше " + number + ":");
            System.out.println(animalsRepository.findOlderAnimal(number));
        }

        @DisplayName("findDuplicate Test")
        @Test
        void findDuplicateTestTrue(){
            System.out.println("========TEST THREE.ONE EXECUTED=======");
            System.out.println("\nДубликаты:");
            //Создаются два одинаковых объекта в начале списка животных
            Assertions.assertTrue(animalsRepository.findDuplicateTrue().isEmpty());
        }
        @DisplayName("findDuplicate Test")
        @Test
        void findDuplicateTestFalse(){
            System.out.println("========TEST THREE.TWO EXECUTED=======");
            System.out.println("\nДубликаты:");
            //Не создаются два одинаковых объекта в начале списка животных
            Assertions.assertFalse(animalsRepository.findDuplicateFalse().isEmpty());
        }

        @DisplayName("findMinConstAnimals Test")
        @Test
        void findMinConstAnimalsTest(){
            System.out.println(animalsRepository.findMinConstAnimals());
        }

        @DisplayName("findAverageAge Test")
        @Test
        void findAverageAgeTest(){
            System.out.println(animalsRepository.findAverageAge());
        }

        @DisplayName("findOldAndExpensive Test")
        @Test
        void findOldAndExpensiveTest(){
            System.out.println(animalsRepository.findOldAndExpensive());
        }
    }
    @Nested
    class ExceptTest{
        @Autowired
        AnimalsRepositoryImpl animalsRepository;

        @Autowired
        CreateAnimalServiceImpl createAnimalService;

        @DisplayName("findOlderAnimal Test with Exceptions")
        @ParameterizedTest
        @ValueSource(ints = {0,2021,2019,1995,2025})
        void findOlderAnimalTestExcept(int number){
            System.out.println("========TEST EXCEPT=======");
            System.out.println("\nЖивотные, дата рождения которых больше " + number + ":");
            System.out.println(animalsRepository.findOlderAnimal(number));
        }

        @DisplayName("findMinConstAnimals Test with Exception")
        @Test
        void findMinConstAnimalsTestExcept(){
            ConcurrentMap<String, CopyOnWriteArrayList<AbstractAnimal>> arrayAnimals2 = createAnimalService.createMasAnimal(2);
            System.out.println(animalsRepository.findMinConstAnimals(arrayAnimals2));
        }

        @DisplayName("Test thread-safe")
        @Test
        void threadSafeTest(){
            ConcurrentMap<String, CopyOnWriteArrayList<AbstractAnimal>> arrayAnimals = new ConcurrentHashMap<>();
            arrayAnimals.put("Test1", new CopyOnWriteArrayList<>());
            arrayAnimals.put("Test2", new CopyOnWriteArrayList<>());
            System.out.println(arrayAnimals);
            ConcurrentMap<String, CopyOnWriteArrayList<AbstractAnimal>> arrayAnimals2 = new ConcurrentHashMap<>();
            arrayAnimals.put("Test1", new CopyOnWriteArrayList<>());
            arrayAnimals.put("Test2", new CopyOnWriteArrayList<>());
            System.out.println(arrayAnimals2);
            Assertions.assertEquals(arrayAnimals,arrayAnimals2);

        }
    }
}
