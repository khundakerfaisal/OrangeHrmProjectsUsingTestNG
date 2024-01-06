package testrunner;

import com.github.javafaker.Faker;
import config.setupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.pimMenuPage;

import java.time.Duration;
import java.util.Random;

public class pimTestRunner extends setupPage {
    @BeforeTest
    public void login(){
        loginPage loginPage=new loginPage(driver);
        loginPage.doLoginWithCred("admin","admin123");
    }
    @Test(priority = 1)
    public void createValidEmployeeID(){
        pimMenuPage pimMenuPage =new pimMenuPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String userName=faker.name().username();
        String password=generateRandomPassword(8);
        pimMenuPage.createEmployee(firstName,lastName,userName,password);
        WebElement headerText = driver.findElement(By.xpath("//h6[text()='Personal Details']"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(headerText));
        String textActual=headerText.getText();
        String textExpected="Personal Details";
        Assert.assertEquals(textActual,textExpected);
    }
    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!@#$%&";
        Random randnumber = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(randnumber.nextInt(chars.length())));
        return sb.toString();
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
