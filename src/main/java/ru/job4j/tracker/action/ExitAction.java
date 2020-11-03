package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;

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
