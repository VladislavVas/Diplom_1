package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType type;
    private final String value;

    public IngredientTypeTest(IngredientType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Parameterized.Parameters(name = "Test data. Ingredient type name and expected value: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {FILLING, "FILLING"},
                {SAUCE, "SAUCE"},
        };
    }

    @Test
    public void ingredientTypeEnumTest() {
        assertEquals(IngredientType.valueOf(value), type);
    }

}