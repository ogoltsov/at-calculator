package com.epam.calculator.operation.addition;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorAdditionalIntTest extends CalculatorAdditionTest {

    @Test(dataProvider = "intAdditionalDataProvider", groups = {"additionOperation"})
    public void intAdditionTest(int a, int b, int expectedResult) {

        int actualResult = getCalculator().addition(a, b);

        String assertMessage = String.format(ADDITIONAL_OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, assertMessage);

    }

}
