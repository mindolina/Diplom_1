package praktikum;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void values() {
        String[] ingredientType = {"SAUCE", "FILLING"};
        assertEquals(Arrays.toString(ingredientType), Arrays.toString(IngredientType.values()));
    }

    @Test
    public void valueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}