package ru.job4j.tracker.input;

/**
 * class ValidateStubInput - реализует чтение данных пользователя с консоли, отлавливает возможные исключительные ситуации связанные с вводом пользователя.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 28.04.2020
 */
public class ValidateStubInput extends ValidateInput {
    private String[] data;
    private int position;

    public ValidateStubInput(String[] data) {
        this.data = data;
    }

    @Override
    public String askStr(String question) {
        return data[position++];
    }
}
