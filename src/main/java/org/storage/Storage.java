package org.storage;

import org.model.Animal;
import org.model.Command;
import org.model.PackAnimal;
import org.model.Pet;
import org.model.implement.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage implements IStorage{
    Map<Integer, Animal> dbAnimals = new HashMap<>();

    public Storage() {
        init();
    }

    private void init(){
        Pet cat = new Cat("Моника", LocalDate.of(2021, 5, 15));

        int per = cat.getAge();

        cat.learnCommand(new Command("Мяукни"));
        dbAnimals.put(cat.getId(), cat);

        Pet dog = new Dog("Сабаня", LocalDate.of(2022, 11, 24));
        dog.learnCommand(new Command("Принести тапки"));
        dog.learnCommand(new Command("Голос!"));
        dbAnimals.put(dog.getId(), dog);

        Pet hamster = new Hamster("Хомячий", LocalDate.of(2025, 12, 20));
        hamster.learnCommand(new Command("Кушать"));
        dbAnimals.put(hamster.getId(), hamster);

        PackAnimal horse = new Horse("Боярышник", LocalDate.of(2018, 6, 18));
        horse.setLoadCapacity(300);
        horse.learnCommand(new Command("Спать!"));
        dbAnimals.put(horse.getId(), horse);

        PackAnimal horse2 = new Horse("Боярышня", LocalDate.of(2020, 5, 6));
        horse2.setLoadCapacity(400);
        horse2.learnCommand(new Command("Галоп!"));
        horse2.learnCommand(new Command("Жуй!"));
        dbAnimals.put(horse2.getId(), horse2);

        PackAnimal donkey = new Donkey("Оси", LocalDate.of(2022, 8, 26));
        donkey.setLoadCapacity(500);
        donkey.learnCommand(new Command("Дай ухо!"));
        dbAnimals.put(donkey.getId(), donkey);

        PackAnimal camel = new Camel("Сигарета", LocalDate.of(2020, 7, 25));
        camel.setLoadCapacity(1000);
        camel.learnCommand(new Command("Сплюнь!"));
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(dbAnimals.values());
    }

    @Override
    public Animal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(Animal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(Animal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        Animal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}
