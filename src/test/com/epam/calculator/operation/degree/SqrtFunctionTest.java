package com.epam.calculator.operation.degree;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtFunctionTest extends CalculatorTest {

    @DataProvider
    public static Object[][] sqrtFunctionTestDataProvider() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {4, 2},
                {0.64, 0.8},
                {-9, Double.NaN}
        };
    }

    @Test(groups = {"degree"}, dataProvider = "sqrtFunctionTestDataProvider")
    public void sqrtFunctionTest(double num, double expectedResult) {

        double actualResult = getCalculator().sqrt(num);

        String message = getExceptionMessage(SQRT_FUNCTION, FUNCTION_EXCEPTION_MESSAGE, num, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);

    }

}
