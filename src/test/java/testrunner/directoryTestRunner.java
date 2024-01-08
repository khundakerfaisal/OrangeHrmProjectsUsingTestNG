package testrunner;

import config.setupPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.directoryPage;
import pages.loginPage;
import utils.Utils;

import java.io.IOException;

public class directoryTestRunner extends setupPage {
    @BeforeTest
    public void login(){
        loginPage loginPage=new loginPage(driver);
        loginPage.doLoginWithCred("admin","admin123");
    }
    @Test
    public void SearchByName() throws InterruptedException, IOException, ParseException {
        directoryPage directorypage=new directoryPage(driver);
        Thread.sleep(1000);
        String firstName= Utils.getEmpID().get("firstName").toString();
        String lastName= Utils.getEmpID().get("lastName").toString();
        String fullName=firstName+" "+lastName;
//        System.out.println(firstName);
        directorypage.searchByEmployeeName(firstName);
        directorypage.txtSearchEmpName.get(1).sendKeys(Keys.SPACE);
        directorypage.txtSearchEmpName.get(1).sendKeys(Keys.ARROW_DOWN);
        directorypage.txtSearchEmpName.get(1).click();
        directorypage.txtSearchEmpName.get(1).sendKeys(Keys.ENTER);
        directorypage.btnSearch.get(1).click();
        Thread.sleep(1500);
        String textActual = driver.findElements(By.className("orangehrm-directory-card-header")).get(0).getText();
//        System.out.println(textActual);
        String textExpected = fullName;
//        System.out.println(textExpected);
        Assert.assertTrue(textActual.contains(textExpected));
    }
    @AfterTest
        public void doLogout(){
        loginPage loginPage=new loginPage(driver);
        loginPage.doLogout();
        String loginTitleActual=driver.findElement(By.className("orangehrm-login-title")).getText();
        String loginExpected="Login";
        Assert.assertEquals(loginTitleActual,loginExpected);
    }
}
