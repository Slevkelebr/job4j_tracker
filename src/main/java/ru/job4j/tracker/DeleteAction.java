package ru.job4j.tracker;

/**
 * class DeleteAction - удалить Item.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 14.04.2020
 */
public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter ID item which want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Operation completed successfully");
        } else {
            System.out.println("Operation failed");
        }
        return true;
    }
}
