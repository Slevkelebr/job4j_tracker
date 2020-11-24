package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MemTrackerTest {

    @Test
    public void testAdd() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        memTracker.add(item1);
        assertThat(memTracker.findAll(), is(List.of(item1)));
    }

    @Test
    public void testFindById() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        memTracker.add(item1);
        Item result = memTracker.findById(item1.getId());
        assertThat(result.getName(), is(item1.getName()));
    }

    @Test
    public void testFindAll() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        memTracker.add(item1);
        List<Item> lists = memTracker.findAll();
        assertThat(lists, is(List.of(item1)));
    }

    @Test
    public void testFindByName() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        memTracker.add(item1);
        List<Item> lists = memTracker.findByName("test1");
        assertThat(lists, is(List.of(item1)));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        Integer id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        Integer id = bug.getId();
        assertTrue(memTracker.delete(id));
    }
}