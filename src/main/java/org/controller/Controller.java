package org.controller;

import org.model.Animal;
import org.model.AnimalType;
import org.model.implement.*;
import org.storage.Storage;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    private Storage dbAnimals;

    public Controller(Storage dbAnimals) {
        this.dbAnimals = dbAnimals;
    }

    public List<Animal> getAnimals() {
        return dbAnimals.getAllAnimals();
    }

    public boolean createAnimal(String name, LocalDate birthDay, AnimalType animalGenius) {
        Animal animal = switch (animalGenius) {
            case CAT -> new Cat(name, birthDay);
            case DOG -> new Dog(name, birthDay);
            case HAMSTER -> new Hamster(name, birthDay);
            case HORSE -> new Horse(name, birthDay);
            case CAMEL -> new Camel(name, birthDay);
            case DONKEY -> new Donkey(name, birthDay);
        };

        return dbAnimals.addAnimal(animal);
    }

    public int removeAnimal(Animal animal) {
        if (animal == null) return -1;
        return  dbAnimals.removeAnimal(animal);
    }
}

