package ru.job4j.tracker;

/**
 * class ConsoleInput - реализует чтение данных пользователя с консоли используя объект Scanner.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 08.04.2020
 */
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select >= 0 && select < max) {
            return select;
        } else {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
    }
}
