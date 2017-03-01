package com.epam.calculator.operation.trigonometric;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CosFunctionTest extends CalculatorTest {

    private String formatPattern;

    @DataProvider(name = "cosFunctionTestDataProvider")
    public static Object[][] cosFunctionTestDataProvider() {
        return new Object[][]{
                {0, 1},
                {45, 0.707},
                {90, 0},
                {180, -1},
                {270, 0},
                {360, 1}
        };
    }

    @Parameters(value = {"formatPattern"})
    @BeforeTest
    public void initTest(@Optional String formatPattern) {
        this.formatPattern = formatPattern;
    }

    @Test(groups = {"trigonometric","trigonometricBaseFunction"}, dataProvider = "cosFunctionTestDataProvider")
    public void cosFunctionTest(double a, double expectedResult) {
        DecimalFormat decimalFormat = new DecimalFormat(formatPattern);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        double actualResult = getCalculator().cos(Math.toRadians(a));

        String formattedActualResult = decimalFormat.format(actualResult);
        String formattedExpectedResult = decimalFormat.format(expectedResult);

        String message = getExceptionMessage(COS_FUNCTION, FUNCTION_EXCEPTION_MESSAGE, a, formattedActualResult, formattedExpectedResult);
        Assert.assertEquals(formattedActualResult, formattedExpectedResult, message);

    }

}
