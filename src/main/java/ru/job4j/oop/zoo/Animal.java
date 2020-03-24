package ru.job4j.oop.zoo;

/**
 * class Animal.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 24.03.2020
 */
public class Animal {
    String name;

    public Animal() {
        super();
        System.out.println("Load Animal.");
    }

    public Animal(String name) {
        super();
        this.name = name;
        System.out.println("Load Animal.");
    }

    public static void main(String[] args) {
        Animal animal = new Predator();
        Animal animal1 = new Tiger("Timon");
    }
}
