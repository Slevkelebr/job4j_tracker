package ru.job4j.tracker;

import java.util.Scanner;

/**
 * class StartUI - консольное приложения для работы с Tracker.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 04.04.2020
 */
public class StartUI {

    /**
     * Метод реализует работу с меню трекера.
     * @param scanner объект для чтения вводнимых данных.
     * @param tracker объект трекера.
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Item ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item.getName() + " " + item.getId());
                }
            } else if (select == 2) {
                System.out.print("Enter ID item which want to replace: ");
                String id = scanner.nextLine();
                System.out.print("Enter new name item: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Operation completed successfully");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 3) {
                System.out.print("Enter ID item which want to delete: ");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("Operation completed successfully");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 4) {
                System.out.print("Enter ID item: ");
                String id = scanner.nextLine();
                System.out.println(tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.print("Enter name item: ");
                String name = scanner.nextLine();
                for (Item item : tracker.findByName(name)) {
                    System.out.println(item.getName() + " " + item.getId());
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    /**
     * Метод выводит меню в консоле.
     */
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
