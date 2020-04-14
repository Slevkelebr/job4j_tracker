package ru.job4j.tracker;

/**
 * interface UserAction - определяет действия меню(системы).
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}