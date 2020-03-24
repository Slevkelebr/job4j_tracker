package ru.job4j.oop.override;

/**
 * class JSONReport.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 24.03.2020
 */
public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator() + System.lineSeparator() +
                "name: " + name + "," + System.lineSeparator() +
                "body: " + body + System.lineSeparator() + System.lineSeparator() + "}";
    }
}
