package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class Tracker - обёртка над массивом Item.
 *
 * @author Sergey Frolov (slevkelebr@yandex.ru)
 * @version 0.2
 * @since 03.04.2020
 */
public class MemTracker {
    /**
     * Массив для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод получения всех заявок совпадающих с ключом.
     * @param key имя заявки.
     * @return список заявок.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод ищет заявку по id.
     * @param id id заявки.
     * @return заявка.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод возвращает индекс заявки по id.
     * @param id id заявки.
     * @return индекс заявки.
     */
    public int indexOf(String id) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Метод замены заявки по id.
     * @param id id заявки.
     * @param item новая заявка.
     * @return true если замена прошла успешна иначе false.
     */
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items.set(index, item);
        return true;
    }

    /**
     * метод удаления заявки.
     * @param id id заявки.
     * @return true если замена прошла успешна иначе false.
     */
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }
}