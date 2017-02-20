package com.epam.calculator.operation;

import com.epam.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class CalculatorDivideOperationTest {

    private Calculator calculator;

    private static String getFormattedNumber(double number, String decimalPattern) {
        DecimalFormat decimalFormat = new DecimalFormat(decimalPattern);
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        return decimalFormat.format(number);
    }

    @BeforeTest
    public void initTest() {
        this.calculator = new Calculator();
    }


    @Test
    @Parameters({"decimalPattern"})
    public void divideDoubleNumbersTest(String decimalPattern) {
        double divideResult = calculator.divide(25.3, 11.3);
        String formattedNumber = getFormattedNumber(divideResult, decimalPattern);

        Assert.assertEquals(formattedNumber, "2.239");

    }

    @Test(dependsOnMethods = {"divideDoubleNumbersTest", "divideZeroOnInteger"}, dataProvider = "divideIntegerNumbersProvider")
    public void divideIntegerNumbersTest(int a, int b, double result) {
        double actualResult = calculator.divide(a, b);
        Assert.assertEquals(actualResult, result);
    }

    @Test
    public void divideZeroOnInteger() {
        double actualResult = calculator.divide(0, 2);
        Assert.assertEquals(actualResult, 0.0);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divideDecimalOnZero() {
        calculator.divide(12.2, 0);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divideIntegerOnZero() {
        calculator.divide(10, 0);
    }

    @DataProvider(name = "divideIntegerNumbersProvider")
    public Object[][] divideIntegerNumbersProvider() {
        return new Object[][]{
                {5, 2, 2.0},
                {10, 3, 3.0},
                {123, 123, 1.0},
                {512, 2, 256},
                {1025, 5, 205},
        };
    }


}
