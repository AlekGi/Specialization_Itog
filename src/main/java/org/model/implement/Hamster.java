package org.model.implement;

import org.model.AnimalType;
import org.model.PackAnimal;
import org.model.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.HAMSTER);
    }
}
