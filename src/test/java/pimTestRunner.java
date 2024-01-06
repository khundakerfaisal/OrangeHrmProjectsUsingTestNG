import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class pimTestRunner extends setupPage{
    @BeforeTest
    public void login(){
        loginPage loginPage=new loginPage(driver);
        loginPage.doLoginWithCred("admin","admin123");
    }
    @Test(priority = 1)
    public void createValidEmployeeID(){
        pimMenuPage pimMenuPage =new pimMenuPage(driver);
        pimMenuPage.createEmployee("md","faisal1","khFaisal1","p@A123456");
        WebElement headerText = driver.findElement(By.xpath("//h6[text()='Personal Details']"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(headerText));
        String textActual=headerText.getText();
        String textExpected="Personal Details";
        Assert.assertEquals(textActual,textExpected);
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
