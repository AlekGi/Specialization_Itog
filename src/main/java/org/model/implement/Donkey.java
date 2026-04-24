package org.model.implement;

import org.model.AnimalType;
import org.model.PackAnimal;

import java.time.LocalDate;

public class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.DONKEY);
    }
}
