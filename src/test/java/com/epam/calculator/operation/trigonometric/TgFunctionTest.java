package com.epam.calculator.operation.trigonometric;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TgFunctionTest extends CalculatorTest {

    private String formatPattern;

    @DataProvider
    public static Object[][] tgFunctionTestDataProvider() {
        return new Object[][]{
                {0, 0},
                {30, 0.5},
                {45, 0.7071},
                {90, Double.POSITIVE_INFINITY},
                {180, -0},
                {270, Double.NEGATIVE_INFINITY},
                {360, -0}
        };
    }

    @BeforeTest
    @Parameters({"formatPattern"})
    public void initTest(String formatPattern) {
        this.formatPattern = formatPattern;
    }

    @Test(groups = {"trigonometric", "trigonometricCompositeFunction"}, dataProvider = "tgFunctionTestDataProvider")
    public void tgFunctionTest(double a, double expectedResult) {
        DecimalFormat decimalFormat = new DecimalFormat(formatPattern);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        double actualResult = getCalculator().tg(Math.toRadians(a));

        String formattedActualResult = decimalFormat.format(actualResult);
        String formattedExpectedResult = decimalFormat.format(expectedResult);

        String message = getExceptionMessage(TG_FUNCTION, FUNCTION_EXCEPTION_MESSAGE, a, formattedActualResult, formattedExpectedResult);

        Assert.assertEquals(actualResult, expectedResult, message);
    }

}
