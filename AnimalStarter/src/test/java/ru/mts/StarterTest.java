package ru.mts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class StarterTest {

    @Autowired
    AbstractAnimal createAnimal;
    @Autowired
    AbstractAnimal typeAnimal;
    @Autowired
    AnimalProperties animalProperties;

    @DisplayName("Random in name Test")
    @Test
    void randomNameTest(){
        String name = animalProperties.getNameAnimal();
        String name2 = animalProperties.getNameAnimal();
        System.out.println(name + " " + name2);
        Assertions.assertNotEquals(name, name2);
    }

    @DisplayName("Yml not null Test")
    @Test
    void ymlTestTest(){
        int cnt = animalProperties.countName();
        Assertions.assertEquals(cnt, 0);
    }

    @DisplayName("Rename Animal Test")
    @Test
    void renameAnimalTest(){
        String name = animalProperties.chooseNameAnimal(1);
        String name2 = animalProperties.chooseNameAnimal(3);
        System.out.println(name + " " + name2);
        Assertions.assertEquals(name, name2);
    }

    @DisplayName("Check Class Animal Test")
    @Test
    void checkClassAnimalTest(){
        typeAnimal = typeAnimal.choiceAnimal(0); //Class dog
        assert typeAnimal instanceof Dog;
    }

}
