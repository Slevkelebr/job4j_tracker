package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

/**
 * class ReplaceAction - редактировать Item.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Replace Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        Integer id = input.askInt("Enter ID item which want to replace: ");
        String name = input.askStr("Enter new name item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Operation completed successfully");
        } else {
            System.out.println("Operation failed");
        }
        return true;
    }
}
