package testrunner;

import config.setupPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
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
    @Test(priority = 1, description = "Invalid Employee ID ")
    public void searchByEmployeeInvalidId() throws IOException, ParseException, InterruptedException {
        searchEmployeePage searchEmployeePage =new searchEmployeePage(driver);
        String employeeID= String.valueOf(420);
        searchEmployeePage.searchEmployee(employeeID);
        String textActual=driver.findElements(By.className("oxd-toast-container")).get(0).getText();
//        System.out.println(textActual);
        String textExpected="No Records Found";
//        System.out.println(textExpected);
        Assert.assertTrue(textActual.contains(textExpected));
    }
    @Test(priority = 2, description = "Search by updated Employee Id")
    public void searchByEmployeeId() throws IOException, ParseException, InterruptedException {
        searchEmployeePage searchEmployeePage =new searchEmployeePage(driver);
        String employeeID= Utils.getEmpID().get("employeeID").toString();
        searchEmployeePage.searchEmployee(employeeID);
//        String textActual=employeeID;
        String textActual=employeeID;
//        System.out.println(textActual);
        String textExpected=employeeID;
//        System.out.println(textExpected);
        Assert.assertTrue(textActual.contains(textExpected));
    }


}
