package testrunner;

import config.setupPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.directoryPage;
import pages.loginPage;
import utils.Utils;

import java.io.IOException;
import java.security.Key;

public class directoryTestRunner extends setupPage {
    @BeforeTest
    public void login(){
        loginPage loginPage=new loginPage(driver);
        String adminUser=System.getProperty("username");
        String adminPass=System.getProperty("password");
        loginPage.doLoginWithCred(adminUser,adminPass);
    }
    @Test(priority = 1, description = "Search by InValid Employee Name")
    public void SearchByfirstName() throws InterruptedException, IOException, ParseException {
        directoryPage directorypage=new directoryPage(driver);
        Thread.sleep(1000);
        String firstName= Utils.getEmpID().get("firstName").toString();
        String lastName= Utils.getEmpID().get("lastName").toString();
        String fullName=(firstName+" "+lastName).trim();
        directorypage.searchByEmployeeName(firstName);
        directorypage.txtSearchEmpName.get(1).sendKeys(Keys.ENTER);
        directorypage.btnSearch.get(1).click();
        Thread.sleep(1500);
        String textActual = driver.findElements(By.xpath("//span[text()='Invalid']")).toString();
//        System.out.println(textActual);
        String textExpected = "Invalid";
//        System.out.println(textExpected);
        Assert.assertTrue(textActual.contains(textExpected));

    }

    @Test(priority = 2, description = "Search by Valid Employee Name")
    public void SearchByEmployeeName() throws InterruptedException, IOException, ParseException {
        directoryPage directorypage = new directoryPage(driver);
        Thread.sleep(1000);
        String firstName = Utils.getEmpID().get("firstName").toString();
        String lastName = Utils.getEmpID().get("lastName").toString();
        String fullName = (firstName + " " + lastName).trim();
        System.out.println(firstName);
        directorypage.searchByEmployeeName(firstName);
        Thread.sleep(3000);
        directorypage.txtSearchEmpName.get(1).sendKeys(Keys.SPACE);
        Thread.sleep(2000);
        directorypage.txtSearchEmpName.get(1).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
//        directorypage.txtSearchEmpName.get(1).click();
        directorypage.txtSearchEmpName.get(1).sendKeys(Keys.ENTER);
        directorypage.btnSearch.get(1).click();
        Thread.sleep(1500);
        String textActual = driver.findElements(By.className("orangehrm-directory-card-header")).get(0).getText();
//        System.out.println(textActual);
        String textExpected = fullName;
//        System.out.println(textExpected);
        Assert.assertTrue(textActual.contains(textExpected));
    }
    @AfterTest(description = "User Logout successfully")
        public void doLogout(){
        loginPage loginPage=new loginPage(driver);
        loginPage.doLogout();
        String loginTitleActual=driver.findElement(By.className("orangehrm-login-title")).getText();
        String loginExpected="Login";
        Assert.assertEquals(loginTitleActual,loginExpected);
    }
}
