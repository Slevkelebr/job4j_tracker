package ru.job4j.tracker;

/**
 * class FindIdAction - поиск Item по id.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find by id Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID item: ");
        String answer = null;
        if (tracker.findById(id).getName() != null) {
            answer = tracker.findById(id).getName();
        }
        System.out.println(answer);
        return true;
    }
}
