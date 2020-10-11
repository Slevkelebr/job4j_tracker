package ru.job4j.tracker;

import java.util.List;

/**
 * class ShowAllAction - показать все объекты Item.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public class ShowAllAction implements UserAction{
    @Override
    public String name() {
        return "=== All Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item.getName() + " " + item.getId());
        }
        return true;
    }
}
