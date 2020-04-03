package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class ProductTest {

    @Test
    public void eqProduct() {
        Product first = new Product("Milk", 100);
        Product second = new Product("Milk", 100);
        assertThat(first, is(second));
    }
}