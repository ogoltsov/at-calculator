package com.epam.calculator;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestRunner {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        TestNG testing = new TestNG();
        for (XmlSuite suite : new Parser("./testing.xml").parseToList()) {
            testing.setCommandLineSuite(suite);
        }
        testing.run();
    }
}
