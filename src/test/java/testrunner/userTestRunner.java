package testrunner;

import config.setupPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import utils.Utils;

import java.io.IOException;

public class userTestRunner extends setupPage {
    loginPage loginPage;
    @Test(priority = 3,description = "Login with unauthorized user")
    public void doLoginByUnauthorizedUser() throws IOException, ParseException {
        loginPage=new loginPage(driver);
        String firstName= Utils.getEmpID().get("firstName").toString();
//        String lastName= Utils.getEmpID().get("lastName").toString();
//        String fullName=firstName+" "+lastName;
//        String userName= Utils.getEmpID().get("firstName").toString();
        String password= Utils.getEmpID().get("password").toString();
        loginPage.doLoginWithCred(firstName,password);
        String textActual=driver.findElements(By.className("oxd-alert-content-text")).get(0).getText();
        String textExpected="Invalid credentials";
        Assert.assertTrue(textActual.contains(textExpected));
    }
    @Test(priority = 4,groups = "smoke", description="User Login Successfully with valid Credential")
    public void doLoginByUser() throws IOException, ParseException {
        loginPage = new loginPage(driver);
        String firstName = Utils.getEmpID().get("firstName").toString();
        String lastName = Utils.getEmpID().get("lastName").toString();
        String userName = Utils.getEmpID().get("userName").toString();
        String password = Utils.getEmpID().get("password").toString();
        loginPage.doLoginWithCred(userName, password);
        String fullName = firstName + " " + lastName;
        String textActual=driver.findElement(By.className("oxd-userdropdown-name")).getText();
        System.out.println(textActual);
        String textExpected=fullName;
        System.out.println(textExpected);
        Assert.assertTrue(textActual.contains(textExpected));

    }
    @Test(priority = 5,description="Full name is showing successfully")
    public void fullNameCheck() throws IOException, ParseException {
        loginPage = new loginPage(driver);
        String firstName = Utils.getEmpID().get("firstName").toString();
        String lastName = Utils.getEmpID().get("lastName").toString();
        String fullName = firstName + " " + lastName;
        String textActual=driver.findElement(By.className("oxd-userdropdown-name")).getText();
        System.out.println(textActual);
        String textExpected=fullName;
        System.out.println(textExpected);
        Assert.assertTrue(textActual.contains(textExpected));

    }

}
