package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;

    @Before
    public void setUp() {
        this.burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.moveIngredient(0, 1);
        assertEquals("cutlet", burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        float bunPrice = 100;
        float ingredientPrice = 200;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(bunPrice * 2 + ingredientPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        String expected = "(==== white bun ====)" + "\r\n" +
                "= sauce hot sauce =" + "\r\n" +
                "(==== white bun ====)" + "\r\n"
                + "\r\n" + "Price: 500,000000\r\n";
        assertEquals(expected, burger.getReceipt());
    }
}