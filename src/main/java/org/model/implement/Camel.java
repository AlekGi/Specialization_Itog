package org.model.implement;

import org.model.AnimalType;
import org.model.Command;
import org.model.PackAnimal;

import java.time.LocalDate;

public class Camel extends PackAnimal {

    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalType(AnimalType.CAMEL);
    }
}
