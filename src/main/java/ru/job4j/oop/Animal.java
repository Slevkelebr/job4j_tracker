package ru.job4j.oop;

/**
 * class Animal.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 24.03.2020
 */
public class Animal {
    public Animal() {
        super();
        System.out.println("Load Animal.");
    }

    public static void main(String[] args) {
        Animal animal = new Predator();
        Animal animal1 = new Tiger();
    }
}
