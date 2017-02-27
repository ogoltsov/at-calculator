package com.epam.calculator.operation.degree;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowFunctionTest extends CalculatorTest {

    @DataProvider
    public static Object[][] powFunctionTestDataProvider() {
        return new Object[][]{
                {1, 1, 1},
                {10, 0, 1},
                {0, 12, 0},
                {2, 2, 4},
                {-2, 2, 4},
        };
    }

    @Test(groups = {"degree"}, dataProvider = "powFunctionTestDataProvider")
    public void powFunctionTest(int num, int degree, double expectedResult) {

        double actualResult = getCalculator().pow(num, degree);

        String message = getExceptionMessage(POW_FUNCTION, FUNCTION_EXCEPTION_MESSAGE, num, degree, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, message);

    }

}
