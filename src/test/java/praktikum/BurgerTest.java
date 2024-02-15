package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientTwo;
    @Mock
    Bun bun;


    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientTwo, burger.ingredients.get(0));

    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(30f);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(50f);
        Assert.assertEquals(100f, burger.getPrice(), 0);


    }

    @Test
    public void testGetReceipt() {
        String nameBun = "Космический бургер";
        String ingredientName = "галактический";
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(nameBun);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(30f);
        Mockito.when(ingredient.getPrice()).thenReturn(40f);
        float expectedpriceBurget = 100f;
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n", nameBun, SAUCE.toString().toLowerCase(), ingredientName, nameBun, expectedpriceBurget);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());

    }
}