package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data. Ingredient type, name and price: {0} {1} {3}")
    public static Object[][] getData() {
        return new Object[][]{
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }

}