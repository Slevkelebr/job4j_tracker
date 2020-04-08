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
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItem(tracker);
            } else if (select == 2) {
                StartUI.replace(input, tracker);
            } else if (select == 3) {
                StartUI.delete(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    /**
     * Метод создает новый объект Item и добавляет его в tracker.
     * @param input объект для чтения вводимых данных.
     * @param tracker объект трекера.
     */
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    /**
     * Метод выводит все объекты Item в консоль.
     * @param tracker объект трекера.
     * @return
     */
    public static void showAllItem (Tracker tracker) {
        System.out.println("=== All Item ====");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item.getName() + " " + item.getId());
        }
    }

    /**
     * Метод редактирует Item.
     * @param input объект для чтения вводимых данных.
     * @param tracker объект трекера.
     */
    public static void replace(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID item which want to replace: ");
        String name = input.askStr("Enter new name item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Operation completed successfully");
        } else {
            System.out.println("Operation failed");
        }
    }

    /**
     * Метод удаляет заявку из трекера.
     * @param input объект для чтения вводимых данных.
     * @param tracker объект трекера.
     */
    public static void delete(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID item which want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Operation completed successfully");
        } else {
            System.out.println("Operation failed");
        }
    }

    /**
     * Метод ищет заявку по id.
     * @param input объект для чтения вводимых данных.
     * @param tracker объект трекера.
     */
    public static void findById(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID item: ");
        System.out.println(tracker.findById(id).getName());
    }

    /**
     * Метод ищет заявку по name.
     * @param input объект для чтения вводимых данных.
     * @param tracker объект трекера.
     */
    public static void findByName(Input input, Tracker tracker) {
        System.out.print("Enter name item: ");
        String name = input.askStr("Enter name item: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(item.getName() + " " + item.getId());
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