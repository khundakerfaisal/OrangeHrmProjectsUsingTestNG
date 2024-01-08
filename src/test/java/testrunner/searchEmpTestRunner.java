package testrunner;

import config.setupPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.searchEmployeePage;
import utils.Utils;

import java.io.IOException;

public class searchEmpTestRunner extends setupPage {
    @BeforeTest
    public void login(){
        loginPage loginPage=new loginPage(driver);
        loginPage.doLoginWithCred("admin","admin123");
    }
    @Test
    public void searchByEmployeeId() throws IOException, ParseException, InterruptedException {
        searchEmployeePage searchEmployeePage =new searchEmployeePage(driver);

        String employeeID= (String) Utils.getEmpID().get("employeeID").toString();

        searchEmployeePage.searchEmployee(employeeID);
    }
//    @AfterTest
//    public void doLogout(){
//        loginPage loginPage=new loginPage(driver);
//        loginPage.doLogout();
//        String loginTitleActual=driver.findElement(By.className("orangehrm-login-title")).getText();
//        String loginExpected="Login";
//        Assert.assertEquals(loginTitleActual,loginExpected);
//    }
}
