package mavenTestNGHomework;

import Homework.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {

    Calculator calculator;

        @BeforeClass
    public void beforeStart() {
        System.out.println("Homework check has started");
    }

    @BeforeMethod
    public void startCalculator() {
        System.out.println("Calculation check started");
    }

    @Test
    public void testAddMethod() {
        calculator = new Calculator();
        Assert.assertEquals(calculator.add(10, 20), 30, "Check this method has issues");
    }

    @Test
    public void testSubtractMethod() {
        calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(10, 7), 3, "Check this method has issues");
    }

    @Test
    public void testDivideMethod() {
        calculator = new Calculator();
        Assert.assertEquals(calculator.divide(30, 15), 2, "Check this method has issues");
    }

    @Test
    public void testMultiplyMethod() {
        calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(5, 3), 15, "Check this method has issues");
    }

    @AfterMethod
    public void endCalculation() {
        System.out.println("End of Calculation check");
    }
    @AfterClass
    public void afterTest() {
        System.out.println("The test has finished");
    }
}
