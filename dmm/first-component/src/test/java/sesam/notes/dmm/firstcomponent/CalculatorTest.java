package sesam.notes.dmm.firstcomponent;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    @DataProvider(name = "valid")
    public static Object[][] valid() {
        return new Object[][] { { 2, 2, 4 }, { 2, 3, 5 }, { 5, 2, 7 } };
    }

    @DataProvider(name = "invalid")
    public static Object[][] invalid() {
        return new Object[][] { { 2, 2, 5 }, { 2, 3, 7 } };
    }

    @Test(dataProvider = "valid")
    public void sumVaildProvider(Integer a, Integer b, Integer result) throws Exception {
        Assert.assertEquals(Calculator.sum(a, b), result);
    }

    @Test(dataProvider = "invalid", enabled = false)
    public void sumInvalidProvider(Integer a, Integer b, Integer result) throws Exception {
        Assert.assertEquals(Calculator.sum(a, b), result, "Fail expected setup verification");
    }

}
