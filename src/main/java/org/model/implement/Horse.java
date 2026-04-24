package org.model.implement;

import org.model.AnimalType;
import org.model.PackAnimal;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.HORSE);
    }
}
