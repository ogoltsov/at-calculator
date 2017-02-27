package com.epam.calculator.operation.arithmetic;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractOperationTest extends CalculatorTest {

    @DataProvider(name = "intSubtractTestDataProvider")
    public static Object[][] intSubtractTestDataProvider() {
        return new Object[][]{
                {1, 0, 1},
                {0, 1, -1},
                {0, -1, 1},
                {-1, 1, -2},
        };
    }

    @DataProvider(name = "doubleSubtractTestDataProvider")
    public static Object[][] doubleSubtractTestDataProvider() {
        return new Object[][]{
                {1.1, 0.1, 1.0},
                {0.0, 1.2, -1.2},
                {0.99, -0.01, 1.0}
        };
    }

    @Test(dataProvider = "doubleSubtractTestDataProvider", groups = {"subtractOperation"})
    public void doubleSubtractTest(double a, double b, double expectedResult) {
        double actualResult = getCalculator().sub(a, b);
        String message = getExceptionMessage(SUBTRACT, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);

        Assert.assertEquals(actualResult, expectedResult, message);
    }

    @Test(dataProvider = "intSubtractTestDataProvider", groups = {"subtractOperation"})
    public void intSubtractTest(int a, int b, int expectedResult) {
        double actualResult = getCalculator().sub(a, b);
        String message = getExceptionMessage(SUBTRACT, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);

        Assert.assertEquals(actualResult, expectedResult, message);
    }

}
