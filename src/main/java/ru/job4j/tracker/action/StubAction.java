package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;

/**
 * class StubAction - класс для тестирования StartUI.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
