package ru.job4j.tracker;

/**
 * interface Input - определяет работу по получению данных от пользователя в консоли.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 08.04.2020
 */
public interface Input {

    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
