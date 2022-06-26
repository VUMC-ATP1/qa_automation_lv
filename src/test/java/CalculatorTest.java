import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {


    @Test
    public void testAddMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10.00, 20.00), 30.00); // test that's checks the add method 10+20=30
    }
    @Test
    public void testSubtractMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(10.00, 7.50), 2.50);
    }
    @Test
    public void testDivideMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(30.00, 15.00), 2.00);
    }
    @Test
    public void testMultiplyMethod() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiple(5.10, 3.20), 16.32, "Check this method has issues");
    }


}
