package ru.job4j.tracker.input;

/**
 * class StubInput - позволяет тестировать class StartUI.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.3
 * @since 08.04.2020
 */
public class StubInput implements Input {

    /**
     * Варианты ответов пользователя.
     */
    private final String[] answers;
    /**
     * Счетчик позиции ответа.
     */
    private int position = 0;

    /**
     * Конструктор.
     * @param answers варианты ответов пользователя.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select < 0 || select >= max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }
}
