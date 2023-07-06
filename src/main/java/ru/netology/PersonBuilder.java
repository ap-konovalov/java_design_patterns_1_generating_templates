package ru.netology;

import ru.netology.entities.Person;

public class PersonBuilder {

    private String name;
    private String surname;

    private int age;

    private String address;

    private boolean isSetAge;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive number");
        }
        this.age = age;
        this.isSetAge = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (isSurnameNotFilled() && isNameNotFilled()) {
            throw new IllegalStateException("Required fields 'surname' and 'name' should be filled");
        }
        if (isSurnameNotFilled()) {
            throw new IllegalStateException("Required field 'surname' should be filled");
        }
        if (isNameNotFilled()) {
            throw new IllegalStateException("Required field 'name' should be filled");
        }
        Person person;
        if (isSetAge) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        if (address != null && !address.isBlank()) {
            person.setAddress(address);
        }
        return person;
    }

    private boolean isNameNotFilled() {
        return name == null || name.isBlank();
    }

    private boolean isSurnameNotFilled() {
        return surname == null || this.surname.isBlank();
    }
}
