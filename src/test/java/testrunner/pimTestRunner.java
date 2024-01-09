package testrunner;

import com.github.javafaker.Faker;
import config.setupPage;
import net.bytebuddy.build.Plugin;
import org.json.simple.parser.ParseException;
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
import utils.Utils;

import java.io.IOException;
import java.time.Duration;
import java.util.PriorityQueue;

import static utils.Utils.generateRandomPassword;

public class pimTestRunner extends setupPage {
    @BeforeTest
    public void login(){
        loginPage loginPage=new loginPage(driver);
        loginPage.doLoginWithCred("admin","admin123");
    }
    @Test(priority = 1, description = "Doesn't create employee without Username")
    public void createWithoutUsername() throws IOException, ParseException, InterruptedException {
        pimMenuPage pimMenuPage =new pimMenuPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String employeeId = String.valueOf(Utils.generateRandomNumber(10000, 99999));
        String password=generateRandomPassword();
        pimMenuPage.createEmployee(firstName,lastName,employeeId,password);
        String textActual = String.valueOf(driver.findElement(By.xpath("//span[text()='Required']")));
//        System.out.println(textActual);
        String textExpected = "Required";
        Assert.assertTrue(textActual.contains(textExpected));
    }
    @Test(priority = 2, description = "Doesn't create employee without Password Matching")
    public void createPasswordNotMatch() throws IOException, ParseException, InterruptedException {
        pimMenuPage pimMenuPage =new pimMenuPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String employeeId = String.valueOf(Utils.generateRandomNumber(10000, 99999));
        String userName=faker.name().username();
        String password="p1234567";
        pimMenuPage.createEmployee(firstName,lastName,employeeId,userName,password);
        String textActual = driver.findElements(By.className("oxd-text")).get(16).getText();;
        System.out.println(textActual);
        String textExpected = "For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers";
        Assert.assertTrue(textActual.contains(textExpected));

    }
    @Test(priority = 3, description = "Create employee Successfully with valid info")
    public void createValidEmployeeID() throws IOException, ParseException, InterruptedException {
        pimMenuPage pimMenuPage =new pimMenuPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String employeeId = String.valueOf(Utils.generateRandomNumber(10000, 99999));
        String userName=faker.name().username();
        String password=generateRandomPassword();
        System.out.println(password);
        pimMenuPage.createEmployee(firstName,lastName,employeeId,userName,password);
        WebElement headerText = driver.findElement(By.xpath("//h6[text()='Personal Details']"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(headerText));
        String textActual=headerText.getText();
        String textExpected="Personal Details";
        Assert.assertEquals(textActual,textExpected);
        Utils.saveEmployees(firstName,lastName,employeeId,userName,password);

    }

}
