package com.epam.calculator.operation.divide;

import org.testng.annotations.Test;

public class CalculatorDivideIntTest extends CalculationDivideTest {

    @Test(dependsOnGroups = "additionOperationTest", groups = "divideOperationTest")
    public void some(){
        System.out.println("SOME");
    }

}
