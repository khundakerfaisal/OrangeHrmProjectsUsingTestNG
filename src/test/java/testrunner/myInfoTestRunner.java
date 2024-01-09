package testrunner;

import config.setupPage;
import jdk.jshell.execution.Util;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.myInfoPage;
import utils.Utils;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

public class myInfoTestRunner extends setupPage {
    @BeforeTest
    public void login() throws IOException, ParseException {
        loginPage loginPage = new loginPage(driver);
//        loginPage.doLoginWithCred("admin","admin123");
        String userName= Utils.getEmpID().get("userName").toString();
        String password= Utils.getEmpID().get("password").toString();
        loginPage.doLoginWithCred(userName,password);
    }
//    @Test(priority = 1,description="Without Blood selection submit successfully")
//    public void withoutSelectBloodAndGender() throws InterruptedException {
//        myInfoPage myInfoPage = new myInfoPage(driver);
////        myInfoPage.menuItems.get(5).click();
//        myInfoPage.menuItems.get(2).click();
//        WebElement bloodSubmit = driver.findElements(By.className("oxd-button")).get(1);
//
//        bloodSubmit.click();
//        String textActual= String.valueOf(driver.findElements(By.className("oxd-toast-container")).get(0));
//        String textExpected="Successfully Saved";
//        Assert.assertTrue(textActual.contains(textExpected));
//        Thread.sleep(1000);
//
//    }
    @Test(priority = 2,description="Gender and Blood selection successfully")
    public void selectBloodAndGender() throws InterruptedException {
        myInfoPage myInfoPage = new myInfoPage(driver);
//        myInfoPage.menuItems.get(5).click();
        myInfoPage.menuItems.get(2).click();

        Utils.scrollPage(driver);
//        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
//        WebElement radioBtn = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='radio' and @value='1']")));
//        radioBtn.click();

        WebElement radioBtn = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioBtn);

//        System.out.println(radioBtn);
//        Thread.sleep(3000);
        WebElement genderSubmit = driver.findElements(By.className("oxd-button")).get(0);
        Thread.sleep(1000);
        genderSubmit.click();
        Thread.sleep(1500);
        WebElement selectElement = driver.findElements(By.className("oxd-select-text-input")).get(2);
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", selectElement);


//        WebElement selectElement = driver.findElements(By.cssSelector("oxd-select-text-input")).get(2);
        selectElement.click();
        selectElement.sendKeys(Keys.ARROW_DOWN);
        selectElement.sendKeys(Keys.ARROW_DOWN);
        selectElement.sendKeys(Keys.ARROW_DOWN);
        selectElement.sendKeys(Keys.ARROW_DOWN);
        selectElement.sendKeys(Keys.ARROW_DOWN);
        selectElement.sendKeys(Keys.ENTER);
        String textActual=driver.findElements(By.className("oxd-select-text-input")).get(2).getText();
        String textExpected="O+";
        Assert.assertTrue(textActual.contains(textExpected));
//        Thread.sleep(3000);
        WebElement bloodSubmit = driver.findElements(By.className("oxd-button")).get(1);

        bloodSubmit.click();
        Thread.sleep(1000);
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
