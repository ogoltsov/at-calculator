package com.epam.calculator.operation.logical;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class isNegativeNumber extends CalculatorTest {

    @DataProvider
    public static Object[][] negativeNumbersTestDataProvider() {
        return new Object[][]{
                {-1, true},
                {1, false},
                {-10, true},
                {10, false},
                {0, false}
        };
    }

    @Test(groups = {"logical"}, dataProvider = "negativeNumbersTestDataProvider")
    public void isNegativeNumberTest(long num, boolean expectedResult) {
        boolean actualResult = getCalculator().isNegative(num);

        Assert.assertEquals(actualResult, expectedResult, "FUCKING ERROR!");


    }

}
