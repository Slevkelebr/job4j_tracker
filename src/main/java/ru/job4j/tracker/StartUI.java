package ru.job4j.tracker;

/**
 * class StartUI - консольное приложения для работы с Tracker.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.04.2020
 */
public class StartUI {

    /**
     * Метод реализует работу с меню трекера.
     * @param input объект для чтения вводимых данных.
     * @param tracker объект трекера.
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Item ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item.getName() + " " + item.getId());
                }
            } else if (select == 2) {
                String id = input.askStr("Enter ID item which want to replace: ");
                String name = input.askStr("Enter new name item: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Operation completed successfully");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 3) {
                String id = input.askStr("Enter ID item which want to delete: ");
                if (tracker.delete(id)) {
                    System.out.println("Operation completed successfully");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 4) {
                String id = input.askStr("Enter ID item: ");
                System.out.println(tracker.findById(id).getName());
            } else if (select == 5) {
                System.out.print("Enter name item: ");
                String name = input.askStr("Enter name item: ");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
