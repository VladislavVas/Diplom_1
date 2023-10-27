package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void sauceEnumTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), SAUCE);
    }

    @Test
    public void fillingEnumTest() {
        assertEquals(IngredientType.valueOf("FILLING"), FILLING);
    }

}