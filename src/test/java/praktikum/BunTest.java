package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BunTest {

    private Bun bun;

    @Test
    @Parameters({
            "b, 100.0",
            "white bun, 100.0",
            "bun_with_long_name_for_test, 100.0"})
    public void positiveBunNameTest(String name, float price) {
        bun = new Bun(name, price);
        assertEquals(bun.getName(), name);
    }

    @Test
    @Parameters({
            "b, 0.01",
            "black bun, 10.50",
            "bun_with_long_name_for_test, 1000000.99"})
    public void positiveBunPriceTest(String name, float price) {
        bun = new Bun(name, price);
        assertEquals(bun.getPrice(), price, 0);
    }

    @Test
    @Parameters({
            "1234, 100.0",
            "!@#$#$, 100.0",
            "   , 100.0"})
    public void negativeCreateBunNameTest(String name, float price) {
        try {
            bun = new Bun(name, price);
            fail("Expected IllegalArgumentException. Missing field validation");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    @Parameters({
            "b, -1",
            "simple bun, -0.01",
            "bun_with_long_name_for_test, -10000000000"})
    public void negativeCreateBunPriceTest(String name, float price) {
        try {
            bun = new Bun(name, price);
            fail("Expected IllegalArgumentException. Missing field validation");
        } catch (Exception ignored) {
        }
    }

    @Test
    @Parameters({
            "red bun, 100.0"})
    public void privateFieldsBunClassTest(String name, float price) {
        bun = new Bun(name, price);
        bun.name = "new name";
        bun.price = 0;
        assertEquals("Name field is not private", name, bun.getName());
        assertEquals("Price field is not private", price, bun.getPrice(), 0);
    }

}
