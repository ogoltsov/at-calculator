package com.epam.calculator.operation.addition;

import com.epam.calculator.operation.CalculatorTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorAdditionTest extends CalculatorTest {

    public static final String ADDITIONAL_OPERATION_EXCEPTION_MESSAGE = "Addition numbers (%s,%s) operation exception: actual result: [%s], expected: [%s]";


    public CalculatorAdditionTest() {
        super();
    }

    @DataProvider(name = "doubleAdditionalDataProvider", parallel = true)
    public Object[][] doubleAdditionalDataProvider() {
        return new Object[][]{
                {0.1, -0.1, 0},
                {0.1, 0.1, 0.2},
                {0, 0.1, 0.1},
                {0, -0.1, -0.1},
        };
    }

    @DataProvider(name = "intAdditionalDataProvider", parallel = true)
    public Object[][] intAdditionalDataProvider() {
        return new Object[][]{
                {Integer.MAX_VALUE, 1, Integer.MAX_VALUE + 1},
                {Integer.MIN_VALUE, 1, Integer.MIN_VALUE + 1},
                {Integer.MIN_VALUE, Integer.MAX_VALUE, -1},
                {0, 1, 1},
                {0, 0, 0},
                {-1, 0, -1},
                {-1, 1, 0},
                {-10, -12, -22},
        };
    }
}
