package ru.netology;

import ru.netology.entities.Person;

//https://github.com/netology-code/jd-homeworks/blob/master/creational/task1/README.md
public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            Person withoutSurname = new PersonBuilder()
                    .setName("Петр")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person withoutName = new PersonBuilder()
                    .setSurname("Петр")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person withoutNameAndSurname = new PersonBuilder()
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person withNegativeAge = new PersonBuilder()
                    .setName("Eva")
                    .setSurname("Brown")
                    .setAge(-1)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}