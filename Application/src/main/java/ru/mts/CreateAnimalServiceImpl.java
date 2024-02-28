package ru.mts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Autowired
    AnimalProperties animalProperties;

    @Autowired
    AbstractAnimal createAnimal;

    @Autowired
    CreateConfiguration createConfiguration;

    public Map<String, List<AbstractAnimal>> createMasAnimal(int N) {
        return createConfiguration.createMasAnimal(N);
    }

    public Map<String, List<AbstractAnimal>> createMasAnimal() {
        int N = 10;
        return createConfiguration.createMasAnimal();
    }
}
