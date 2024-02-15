package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    @Parameterized.Parameter
    public String bunName;
    @Parameterized.Parameter(1)
    public float bunPrice;


    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Краторная булка", 1255},
                {"Булка за которую тебе еще заплатят", -1255},
                {"", 0},
                {"Придумывание длинного названия булочки для бургера увлекательное занятие, жаль не мой конёк", Float.MAX_VALUE},
                {"Б", Float.MIN_VALUE},
                {"Направо пойдешь---> спецсимволы найдешь !№;%:?*()_+/-=[]{}?", 1255.666f},
                {"go left", 1255.000f},

        };
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());

    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}