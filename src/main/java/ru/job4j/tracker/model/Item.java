package ru.job4j.tracker.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * class Item - модель данных заявки.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 03.04.2020
 */
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Timestamp created;

    public Item(String name, String description, Timestamp created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + '}';
    }
}