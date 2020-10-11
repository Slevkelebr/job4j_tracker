package ru.job4j.tracker;

/**
 * class ExitAction - выход из программы.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit Program ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
