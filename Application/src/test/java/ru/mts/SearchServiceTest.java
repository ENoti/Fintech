package ru.mts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        @ValueSource(ints = {2016,2017,2018,2019,2015,2010})
        void findOlderAnimalTest(int number){
            System.out.println("========TEST TWO EXECUTED=======");
            System.out.println("\nЖивотные, дата рождения которых больше " + number + ":");
            animalsRepository.findOlderAnimal(number);
        }
        @DisplayName("findDuplicate Test")
        @Test
        void findDuplicateTestTrue(){
            System.out.println("========TEST THREE.ONE EXECUTED=======");
            System.out.println("\nДубликаты:");
            //Создаются два одинаковых объекта в начале списка животных
            Assertions.assertTrue(animalsRepository.findDuplicateTrue());
        }
        @DisplayName("findDuplicate Test")
        @Test
        void findDuplicateTestFalse(){
            System.out.println("========TEST THREE.TWO EXECUTED=======");
            System.out.println("\nДубликаты:");
            //Не создаются два одинаковых объекта в начале списка животных
            Assertions.assertFalse(animalsRepository.findDuplicateFalse());
        }
    }

}
