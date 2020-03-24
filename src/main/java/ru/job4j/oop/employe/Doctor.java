package ru.job4j.oop.employe;

/**
 * class Doctor.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.1
 * @since 24.03.2020
 */
public class Doctor extends  Profession {
    /**
     * Конструктор.
     * @param name имя.
     * @param surname фамилия.
     * @param education образование.
     * @param birthday день рождение.
     */
    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    /**
     * Ставит диагноз пациенту.
     * @param pacient пациент.
     * @return диагноз
     */
    public Diagnos heal(Pacient pacient) {
        Diagnos d = null;
        return d;
    }
}
