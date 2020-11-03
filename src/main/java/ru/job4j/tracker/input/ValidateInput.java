package ru.job4j.tracker.input;

/**
 * class ValidateInput - реализует чтение данных пользователя с консоли, отлавливает возможные исключительные ситуации связанные с вводом пользователя.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 28.04.2020
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
