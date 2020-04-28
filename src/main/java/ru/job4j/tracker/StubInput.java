package ru.job4j.tracker;

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
    private String[] answers;
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
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        return askInt(question);
    }
}
