package testrunner;

import config.setupPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;

public class loginTestRunner extends setupPage {
    @Test(priority = 1, description = "Invalid credential !Enter Valid credential")
    public void doLoginWithWrongCred() {
        loginPage loginPage = new loginPage(driver);
        loginPage.doLoginWithCred("admin", "wrong@123");
        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        String textExpected = "Invalid credentials";
        Assert.assertTrue(textActual.contains(textExpected));
    }

    @Test(priority = 2,groups = "smoke",description = "Admin Login successfully with Valid credential")
    public void doLoginWithValidCred() {
        loginPage loginPage = new loginPage(driver);
        String adminUser=System.getProperty("username");
        String adminPass=System.getProperty("password");
        loginPage.doLoginWithCred(adminUser,adminPass);
        boolean isImageExists = driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Assert.assertTrue(isImageExists);

    }

    public void doLogout() {
        loginPage loginPage=new loginPage(driver);
        loginPage.doLogout();
    }


}
