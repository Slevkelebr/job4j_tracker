package ru.job4j.oop.employe;

/**
 * class Profession.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 24.03.2020
 */
public class Profession {
   private String name;
   private String surname;
   private String education;
   private String birthday;

    /**
     * Конструктор.
     * @param name имя.
     * @param surname фамилия.
     * @param education образование.
     * @param birthday день рождение.
     */
    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }
}
