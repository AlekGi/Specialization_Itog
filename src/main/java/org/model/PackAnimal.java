package org.model;

import java.time.LocalDate;

/**
 * Вьючное животное
 */
public abstract class PackAnimal extends Animal {

    public static final int DEFAULT_LOAD_CAPACITY = 100;
    /**
     * Грузоподъемность животного, кг
     */
    private  int loadCapacity;


    public PackAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.loadCapacity = DEFAULT_LOAD_CAPACITY;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
