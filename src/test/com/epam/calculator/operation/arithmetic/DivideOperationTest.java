package com.epam.calculator.operation.arithmetic;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideOperationTest extends CalculatorTest {

    @DataProvider(name = "doubleDivideDataProvider", parallel = true)
    public static Object[][] doubleDivideDataProvider() {
        return new Object[][]{
                {0.1, -0.1, -1.0},
                {0.1, 0.1, 1.0},
                {0, -0.1, -0.0},
        };
    }

    @DataProvider(name = "intDivideDataProvider", parallel = true)
    public static Object[][] intDivideDataProvider() {
        return new Object[][]{
                {0, 1, 0.0},
                {-1, 1, -1.0},
                {-10, -2, 5.0},
                {10, -2, -5.0},
        };
    }

    @DataProvider(name = "divideByZeroDataProvider")
    public static Object[][] divideByZeroDataProvider() {
        return new Object[][]{
                {1}, {-1}, {0}
        };
    }

    @Test(groups = {"divideOperation"}, dataProvider = "intDivideDataProvider")
    public void divideIntNumbersTest(int a, int b, double expectedResult) {
        double actualResult = getCalculator().div(a, b);

        String message = getExceptionMessage(DIVIDE, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);
    }

    @Test(groups = {"divideOperation"}, dataProvider = "doubleDivideDataProvider")
    public void divideDoubleNumbersTest(double a, double b, double expectedResult) {
        double actualResult = getCalculator().div(a, b);

        String message = getExceptionMessage(DIVIDE, OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);
    }

    @Test(groups = {"divideOperation"}, dataProvider = "divideByZeroDataProvider", expectedExceptions = {NumberFormatException.class})
    public void divideIntByZeroNumbersTest(long a) {
        getCalculator().div(a, 0);
    }

}
