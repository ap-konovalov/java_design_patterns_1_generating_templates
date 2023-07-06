package ru.netology.entities;

import ru.netology.PersonBuilder;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;

    protected int age;

    protected String address;

    protected boolean isSetAge;
    protected boolean isSetAddress;


    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.isSetAge = true;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.isSetAddress = true;
    }

    public void happyBirthday() {
        if (isSetAge) {
            this.age += 1;
        }
    }

    public boolean hasAge() {
        return this.isSetAge;
    }

    public boolean hasAddress() {
        return this.isSetAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(age)
                .setAddress(address);
    }
}
