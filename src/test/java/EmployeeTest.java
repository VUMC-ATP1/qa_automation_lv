import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    public void testGetName() {
        Employee emp = new Employee();
        emp.setName("Laura");
        Assert.assertEquals(emp.getName(), "Laura", "Check again");
        }

    @Test
    public void testGetSurname() {
        Employee emp = new Employee();
        emp.setSurname("Valtere");
        Assert.assertEquals(emp.getSurname(), "Valtere", "Check again");
    }
    @Test
    public void testGetYear() {
        Employee emp = new Employee();
        emp.setYear(2022);
        Assert.assertEquals(emp.getYear(), 2022, "Check again");
    }
    @Test
    public void testGetRole() {
        Employee emp = new Employee();
        emp.setRole("Developer");
        Assert.assertEquals(emp.getRole(), "Developer", "Check again");
    }
    @Test
    public void testToStringEmployee() {
        Employee emp = new Employee("Laura", "Valtere", 2022, "Developer");
        Assert.assertEquals(emp.getName(), "Laura");
        Assert.assertEquals(emp.getSurname(), "Valtere");
        Assert.assertEquals(emp.getYear(), 2022);
        Assert.assertEquals(emp.getRole(), "Developer");
    }
}


