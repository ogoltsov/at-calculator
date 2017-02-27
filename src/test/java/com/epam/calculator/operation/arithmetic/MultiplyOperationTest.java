package com.epam.calculator.operation.arithmetic;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyOperationTest extends CalculatorTest {

    @DataProvider(name = "multiplyIntNumbersDataProvider")
    public static Object[][] multiplyIntNumbersDataProvider() {
        return new Object[][]{
                {1, 1, 1},
                {1, 0, 0},
                {-1, 1, -1},
                {-1, -1, 1},
        };
    }

    @DataProvider(name = "multiplyDoubleNumbersDataProvider")
    public static Object[][] multiplyDoubleNumbersTestDataProvider() {
        return new Object[][]{
                {0.1, 1.0, 0.1},
                {1.2, 1.8, 2.16},
                {-0.1, 0.22, -0.022}
        };
    }

    @Test(groups = "multiplyOperation", dataProvider = "multiplyIntNumbersDataProvider")
    public void multiplyIntNumbersTest(int a, int b, int expectedResult) {
        long actualResult = getCalculator().mult(a, b);

        String message = getExceptionMessage(MULTIPLY, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);
    }

    @Test(groups = "multiplyOperation", dataProvider = "multiplyDoubleNumbersDataProvider")
    public void multiplyDoubleNumbersTest(double a, double b, double expectedResult) {
        double actualResult = getCalculator().mult(a, b);

        String message = getExceptionMessage(MULTIPLY, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);
    }


}
