package org.model.implement;

import org.model.AnimalType;
import org.model.Pet;

import java.time.LocalDate;

public class Dog extends Pet {

    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.DOG);
    }
}
