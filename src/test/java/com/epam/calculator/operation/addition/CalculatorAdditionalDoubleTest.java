package com.epam.calculator.operation.addition;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorAdditionalDoubleTest extends CalculatorAdditionTest {

    @Test(groups = "additionOperationTest",dataProvider = "doubleAdditionalDataProvider")
    public void doubleAdditionTest(double a, double b, double expectedResult) {
        double actualResult = getCalculator().addition(a, b);

        String assertMessage = String.format(ADDITIONAL_OPERATION_EXCEPTION_MESSAGE, a, b, actualResult, expectedResult);
        Assert.assertEquals(actualResult, expectedResult, assertMessage);
    }
}
