package com.epam.calculator.operation.trigonometric;

import com.epam.calculator.CalculatorTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CtgFunctionTest extends CalculatorTest {

    private final String formatPattern;

    @DataProvider
    public static Object[][] ctgFunctionTestDataProvider() {
        return new Object[][]{
                {90, 0},
                {30, 1.73205},
                {45, 1},
                {60, 0.57735},
                {135, -1},
                {180, Double.NaN},
                {270, 0},
                {360, Double.NaN},
        };
    }
    @Parameters({"formatPattern"})
    public CtgFunctionTest(@Optional String formatPattern) {
        this.formatPattern = formatPattern;
    }


    @Test(groups = {"trigonometric", "trigonometricCompositeFunction"}, dataProvider = "ctgFunctionTestDataProvider")
    public void ctgFunctionTest(double a, double expectedResult) {
        DecimalFormat decimalFormat = new DecimalFormat(formatPattern);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        double actualResult = getCalculator().ctg(Math.toRadians(a));

        String formattedActualResult = decimalFormat.format(actualResult);
        String formattedExpectedResult = decimalFormat.format(expectedResult);

        String message = getExceptionMessage(CTG_FUNCTION, FUNCTION_EXCEPTION_MESSAGE, a, formattedActualResult, formattedExpectedResult);

        Assert.assertEquals(formattedActualResult, formattedActualResult, message);
    }

}
