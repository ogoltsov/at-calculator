package com.epam.calculator.operation.arithmetic;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdditionalOperationTest extends CalculatorTest {

    @DataProvider(name = "doubleAdditionalDataProvider", parallel = true)
    public static Object[][] doubleAdditionalDataProvider() {
        return new Object[][]{
                {0.1, -0.1, 0},
                {0.1, 0.1, 0.2},
                {0, 0.1, 0.1},
                {0, -0.1, -0.1},
        };
    }

    @DataProvider(name = "intAdditionalDataProvider", parallel = true)
    public static Object[][] intAdditionalDataProvider() {
        return new Object[][]{
                {Integer.MIN_VALUE, 1, Integer.MIN_VALUE + 1},
                {Integer.MIN_VALUE, Integer.MAX_VALUE, -1},
                {0, 1, 1},
                {0, 0, 0},
                {-1, 0, -1},
                {-1, 1, 0},
                {-10, -12, -22},
        };
    }

    @Test(dataProvider = "intAdditionalDataProvider", groups = {"additionOperation"})
    public void intAdditionTest(int a, int b, int expectedResult) {
        long actualResult = getCalculator().sum(a, b);

        String message = getExceptionMessage(ADDITIONAL, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);

    }

    @Test(dataProvider = "doubleAdditionalDataProvider", groups = {"additionOperation"})
    public void doubleAdditionTest(double a, double b, double expectedResult) {
        double actualResult = getCalculator().sum(a, b);

        String message = getExceptionMessage(ADDITIONAL, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);
    }

}
