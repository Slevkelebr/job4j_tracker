package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void testAdd() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        tracker.add(item1);
        assertThat(tracker.findAll(), is(new Item[]{item1}));
    }

    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        Item result = tracker.findById(item1.getId());
        assertThat(result.getName(), is(item1.getName()));
    }

    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findAll();
        assertThat(result, is(new Item[] {item1, item2}));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findByName("test1");
        assertThat(result, is(new Item[]{item1}));
    }


}