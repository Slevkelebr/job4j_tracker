package ru.job4j.tracker;

/**
 * class StartUI - консольное приложения для работы с Tracker.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.5
 * @since 05.04.2020
 */
public class StartUI {

    /**
     * Метод реализует работу с меню трекера.
     * @param input объект для чтения вводимых данных.
     * @param tracker объект трекера.
     */
    public void init(Input input, Store tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
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
        UserAction[] actions = {
                new CreateAction(), new ShowAllAction(), new ReplaceAction(), new DeleteAction(), new FindIdAction(), new FindNameAction(), new ExitAction()
        };
        Input input = new ValidateInput();
        Store tracker = new SqlTracker();
        new StartUI().init(input, tracker, actions);
    }
}