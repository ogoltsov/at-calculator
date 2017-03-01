package com.epam.calculator.operation.logical;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveNumber extends CalculatorTest {

    @DataProvider
    public static Object[][] positiveNumbersTestDataProvider() {
        return new Object[][]{
                {1, true},
                {-1, false},
                {10, true},
                {-10, false},
                {0, false}
        };
    }

    @Test(groups = {"logical"}, dataProvider = "positiveNumbersTestDataProvider")
    public void isPositiveNumber(long num, boolean expectedResult) {
        boolean actualResult = getCalculator().isPositive(num);

        Assert.assertEquals(actualResult, expectedResult, "FUCKING ERROR!");


    }

}
