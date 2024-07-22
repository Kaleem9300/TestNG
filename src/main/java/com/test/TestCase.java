package com.test;



import com.epam.tat.module4.Calculator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase {
     Calculator calculator = new Calculator();

    @BeforeMethod
    public void setUpClass() {
        //calculator = new Calculator();
        System.out.println("Before Method");
    }
	/*
	 * @BeforeMethod public void setUpMethod() {
	 * System.out.println("Starting a test method"); }
	 */

    @Test(groups = "Positive")
    public void addTest() {
        double result = calculator.sum(5, 15);
        Assert.assertEquals(result, 20, "Addition Test Passed");
    }

    @Test(groups = "Positive")
    public void subtractTest() {
        double result = calculator.sub(10, 5);
        Assert.assertEquals(result, 5, "Subtraction Test Passed");
    }

    @Test(groups = "Positive")
    public void multiplyTest() {
        double result = calculator.mult(5, 6);
        Assert.assertEquals(result, 30, "Multiplication Test Passed");
    }

    @Test(groups = "Positive")
    public void divideTest() {
        double result = calculator.div(100, 20);
        Assert.assertEquals(result, 5, "Division Test Passed");
    }

    @Test(groups = "Positive")
    public void pp() {
        boolean result = calculator.isPositive(5);
        Assert.assertTrue(result, "Expected number to be positive.");
    }


    @Test(groups = "Negative", expectedExceptions = NumberFormatException.class)
    public void testInvalidInput() {
        calculator.sum(Integer.parseInt("abc"), 5);
    }

    @Test(groups = "Negative", expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.div(10, 0);
    }

    @Test(groups = "Negative", expectedExceptions = ArithmeticException.class)
    public void testOverflow() {
        int result = Integer.MAX_VALUE + 1;
        calculator.sum(result, 1);
    }

    @Test(groups = "Negative")
    public void testBoundaryCondition() {
        double result = calculator.mult(Integer.MAX_VALUE, 2);
        Assert.assertNotEquals(result, Integer.MIN_VALUE); // Check for overflow
    }

    @Test(groups = "Negative", expectedExceptions = NullPointerException.class)
    public void testNullInput() {
        Long nullValue = null;
        calculator.sum(nullValue, 5);
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionData() {
        return new Object[][]{
            {10, 2, 5},
            {20, 4, 5},
            {100, 10, 10}
        };
    }

    @Test(groups = "Negative", dataProvider = "divisionData")
    public void testDivision(Integer dividend, Integer divisor, Integer expected) {
        // Convert Integer to int if necessary
        long result = calculator.div(dividend.intValue(), divisor.intValue());
        Assert.assertEquals(result, expected.longValue());
    }

    @AfterMethod
    public void cleanUpMethod() {
        System.out.println("Test method completed");
    }

   }
