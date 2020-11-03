package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.FindNameAction;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.proxy.ConnectionRollback;
import ru.job4j.tracker.store.SqlTracker;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindNameActionTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCheckOutput() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("fix bug");
            sqlTracker.add(item);
            FindNameAction act = new  FindNameAction();
            act.execute(new StubInput(new String[] {"fix bug"}), sqlTracker);
            String expect = new StringBuilder()
                    .append("Enter name item: ").append(item.getName()).append(" ").append(item.getId()).append(System.lineSeparator())
                    .toString();
            assertThat(new String(out.toByteArray()), is(expect));
            System.setOut(def);
        }
    }

}
