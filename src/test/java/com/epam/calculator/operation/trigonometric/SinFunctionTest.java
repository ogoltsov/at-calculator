package com.epam.calculator.operation.trigonometric;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SinFunctionTest extends CalculatorTest {

    private String formatPattern;

    @DataProvider(name = "sinFunctionTestDataProvider")
    public static Object[][] sinFunctionTestDataProvider() {
        return new Object[][]{
                {0, 0.0},
                {45, 0.7071},
                {90, 1.0},
                {180, 0.0},
                {360, 0.0},
        };
    }


    @Parameters(value = {"formatPattern"})
    @BeforeTest
    public void initTest(String formatPattern) {
        this.formatPattern = formatPattern;
    }

    @Test(groups = {"trigonometric", "trigonometricBaseFunction"}, dataProvider = "sinFunctionTestDataProvider")
    public void sinFunctionTest(double a, double expectedResult) {
        DecimalFormat decimalFormat = new DecimalFormat(formatPattern);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        double actualResult = getCalculator().sin(Math.toRadians(a));

        String roundedActualResult = decimalFormat.format(actualResult);
        String roundedExpectedResult = decimalFormat.format(expectedResult);

        String message = getExceptionMessage(SIN_FUNCTION, FUNCTION_EXCEPTION_MESSAGE, a, roundedActualResult, roundedExpectedResult);

        Assert.assertEquals(roundedActualResult, roundedExpectedResult, message);
    }
}
