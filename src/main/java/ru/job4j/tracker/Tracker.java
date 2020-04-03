package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * class Tracker - обёртка над массивом Item.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 03.04.2020
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод получения списка всех заявок.
     * @return массив всех заявок.
     */
    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        return namesWithoutNull;
    }

    /**
     * Метод получения всех заявок совпадающих с ключом.
     * @param key имя заявки.
     * @return список заявок.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                result[size] = this.items[i];
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    /**
     * Метод ищет заявку по id.
     * @param id id заявки.
     * @return заявка.
     */
    public Item findById(String id) {
        Item rsl = null;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (this.items[index] != null && item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}