package ru.job4j.tracker;

/**
 * class FindNameAction - поиск Item по name.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find by name Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter name item: ");
        String name = input.askStr("Enter name item: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(item.getName() + " " + item.getId());
        }
        return true;
    }
}
