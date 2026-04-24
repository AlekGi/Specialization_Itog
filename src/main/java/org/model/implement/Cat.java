package org.model.implement;

import org.model.AnimalType;
import org.model.Pet;

import java.time.LocalDate;

public class Cat extends Pet {

    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.CAT);
    }
}
