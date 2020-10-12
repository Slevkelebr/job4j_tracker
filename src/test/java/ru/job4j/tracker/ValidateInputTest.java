package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenInvalidInput() {
        String[] data = {"one", "1"};
        ValidateStubInput input = new ValidateStubInput(data);
        input.askInt("Enter", 6);
        assertThat(
                new String(out.toByteArray()),
                is(String.format("Please enter validate data again.%n"))
        );
    }

    @Test
    public void whenInvalidInputMaxNumber() {
        String[] data = {"8", "2"};
        ValidateStubInput input = new ValidateStubInput(data);
        input.askInt("Enter", 6);
        assertThat(
                new String(out.toByteArray()),
                is(String.format("Please select key from menu.%n"))
        );
    }
}