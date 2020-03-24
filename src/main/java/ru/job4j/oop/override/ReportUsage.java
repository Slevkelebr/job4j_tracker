package ru.job4j.oop.override;

/**
 * class ReportUsage.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 24.03.2020
 */
public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        HtmlReport html = new HtmlReport();
        String text1 = html.generate("Report's name", "Report's body");
        System.out.println(text1);
        System.out.println();
        JSONReport jsonReport = new JSONReport();
        String text2 = jsonReport.generate("Report's name", "Report's body");
        System.out.println(text2);
    }
}
