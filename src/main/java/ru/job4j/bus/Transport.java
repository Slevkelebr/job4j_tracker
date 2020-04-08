package ru.job4j.bus;

/**
 * interface Transport - определяет работу транспорта.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 08.04.2020
 */
public interface Transport {

    void go();

    void passengers(int number);

    int costFillUp(int full);
}
