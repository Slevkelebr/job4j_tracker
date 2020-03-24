package ru.job4j.oop.override;

/**
 * class TextReport.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 24.03.2020
 */
public class TextReport {
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
