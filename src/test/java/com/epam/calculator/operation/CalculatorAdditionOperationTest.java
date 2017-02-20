package com.epam.calculator.operation;

import com.epam.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorAdditionOperationTest {

    private Calculator calculator;

    @BeforeMethod
    public void initTest() {
        this.calculator = new Calculator();
    }

    @Test(dataProvider = "additionIntNumbersTestProvider")
    public void additionIntegerTest(int a, int b, int result) {
        Assert.assertEquals(calculator.addition(a, b), result);
    }

    @Test
    public void additionDoubleTest() {
        Assert.assertEquals(calculator.addition(5.2, 5.81), 11.1);
    }

    @Test(dataProvider = "additionIntAndZeroTestProvider")
    public void additionIntAndZeroTest(int a, int b, int result) {
        Assert.assertEquals(calculator.addition(a, b), result);
    }

    @DataProvider(name = "additionIntAndZeroTestProvider")
    public Object[][] additionIntAndZeroTestProvider() {
        return new Object[][]{
                {5, 0, 5},
                {0, 5, 5},
                {0, 0, 0}
        };
    }

    @DataProvider(name = "additionIntNumbersTestProvider")
    public Object[][] additionIntNumbersTestProvider() {
        return new Object[][]{
                {5, 5, 10},
                {0, 0, 0},
                {0, 0, 1},
                {120, 130, 250},
        };
    }

@DataProvider(name = "additionDoubleNumbersTestProvider")
    public Object[][] additionDoubleNumbersTestProvider() {
        return new Object[][]{
                {5, 5, 10},
                {0, 0, 0},
                {0, 0, 1},
                {120, 130, 250},
        };
    }


}
