package ru.job4j.oop.employe;

/**
 * class Engineer.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 24.03.2020
 */
public class Engineer extends  Profession {
    /**
     * Конструктор.
     * @param name имя.
     * @param surname фамилия.
     * @param education образование.
     * @param birthday день рождение.
     */
    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    /**
     * Проектирует проект.
     * @param scheme схема проекта.
     * @return проект.
     */
    public Project design(Scheme scheme) {
        Project project = null;
        return project;
    }
}
