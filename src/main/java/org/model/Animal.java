package org.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private static int counter;
    private final int id = ++counter;

    private AnimalType animalType;

    /**
     * Имя животного
     */
    private String name;

    /**
     * Дата рождения жиотного
     */
    private LocalDate birthDate;

    /**
     * Список выполняемых команд животного
     */
    private List<Command> animalCommand;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalGenius) {
        this.animalType = animalGenius;
    }

    public List<Command> getAnimalCommand() {
        return animalCommand;
    }

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        animalCommand = new ArrayList<>();
    }

    public String getBurthDateAsString() {
        return String.format("%02d-%02d-%4d", birthDate.getDayOfMonth(), birthDate.getMonthValue(),
                birthDate.getYear());
    }

    /**
     * Возвращает возраст живионого в месяцах
     * @return возвраст
     */
    public int getAge() {
        int years = Period.between(birthDate, LocalDate.now()).getYears();
        int months = Period.between(birthDate, LocalDate.now()).getMonths();
        return years * 12 + months;
    }

    /**
     * Добавляет новую команду
     * @param newCommand команды
     * @return true в случае успеха или false - в противном
     */
    public boolean learnCommand(Command newCommand) {
        if (animalCommand.contains(newCommand)){
            return false;
        }
        animalCommand.add(newCommand);
        return true;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
