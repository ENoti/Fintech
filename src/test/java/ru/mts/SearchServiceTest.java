package ru.mts;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.time.LocalDate;

@ComponentScan
class SearchServiceTest {
    AbstractAnimal[] abstractAnimals;
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
        @BeforeEach
        void createAnimal(){
            abstractAnimals = new CreateAnimalServiceImpl().createMasAnimal();
        }

        @DisplayName("findLeapYearNames Test")
        @Test
        void findLeapYearNamesTest(){
            System.out.println("========TEST ONE EXECUTED=======");
            System.out.println(new AnimalsRepositoryImpl().findLeapYearNames());
        }
        @DisplayName("findOlderAnimal Test")
        @ParameterizedTest
        @ValueSource(ints = {6,7,8,9,10,Integer.MAX_VALUE})
        void findOlderAnimalTest(int number){
            System.out.println("========TEST TWO EXECUTED=======");
            System.out.println(new AnimalsRepositoryImpl().findOlderAnimal(number));
        }
        @DisplayName("findDuplicate Test")
        @Test
        void findDuplicateTestTrue(){
            System.out.println("========TEST THREE.ONE EXECUTED=======");
            //Создаются два одинаковых объекта в начале списка животных
            Assertions.assertTrue(new AnimalsRepositoryImpl().findDuplicate());
        }
        @DisplayName("findDuplicate Test")
        @Test
        void findDuplicateTestFalse(){
            System.out.println("========TEST THREE.TWO EXECUTED=======");
            //Не создаются два одинаковых объекта в начале списка животных
            abstractAnimals = new CreateAnimalServiceImpl().createMasAnimal(10);
            Assertions.assertFalse(new AnimalsRepositoryImpl().findDuplicate());
        }
    }

}
