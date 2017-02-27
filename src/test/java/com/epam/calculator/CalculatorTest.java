package com.epam.calculator;

import com.epam.tat.module4.Calculator;

public class CalculatorTest {

    protected static final String ADDITIONAL = "Addition";
    protected static final String DIVIDE = "Divide";
    protected static final String SUBTRACT = "Subtract";
    protected static final String MULTIPLY = "Multiply";
    protected static final String SIN_FUNCTION = "Function Sin(%s)";
    protected static final String COS_FUNCTION = "Function Cos(%s)";
    protected static final String TG_FUNCTION = "Function tg(%s)";
    protected static final String CTG_FUNCTION = "Function ctg(%s)";
    protected static final String POW_FUNCTION = "Function pow(%s,%s)";
    protected static final String SQRT_FUNCTION = "Function sqrt(%s)";

    protected static final String OPERATION_EXCEPTION_MESSAGE = " numbers (%s,%s) operation exception: actual result: [%s], expected: [%s]";
    protected static final String FUNCTION_EXCEPTION_MESSAGE = " exception: actual result: [%s], expected: [%s]";

    private final Calculator calculator;

    protected CalculatorTest() {
        this.calculator = new Calculator();
    }

    protected Calculator getCalculator() {
        return calculator;
    }


    protected String getExceptionMessage(String operation, String messagePattern, Object... args) {
        return String.format(operation + messagePattern, args);
    }


}
