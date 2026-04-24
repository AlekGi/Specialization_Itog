package org.storage;

import org.model.Animal;

import java.util.List;

public interface IStorage {

    /**
     * Возвращает список животных из хранилища
     * @return Список животных
     */
    List<Animal> getAllAnimals();

    /**
     * Возвращает животное по его id из хранилища
     * @return Животное или null если животное с таким id не найдено
     */
    Animal getAnimalById(int animalId);

    /**
     * Добавляет животное в хранилище
     * @return true в случае успеха или false - в противном
     */
    boolean addAnimal(Animal animal);

    /**
     * Удаляет животное из хранилища
     * @return id удаленного животного, или -1 удаляемого животного нет в хранилище
     */
    int removeAnimal(Animal animal);
}
