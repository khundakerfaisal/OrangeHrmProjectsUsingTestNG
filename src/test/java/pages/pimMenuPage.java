package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class pimMenuPage {
    @FindBy(className = "oxd-main-menu-item--name")
    List<WebElement> menuItems;
    @FindBy(className = "oxd-button")
    List<WebElement> btnSubmit;

    @FindBy(name = "firstName")
    WebElement txtFirstName;
    @FindBy(name = "lastName")
    WebElement txtLastName;
    @FindBy(className = "oxd-switch-input")
    WebElement toggleButton;

    @FindBy(className = "oxd-input")
    List<WebElement> txtFields;

    public  pimMenuPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void createEmployee(String firstName,String lastName,String employeeId,String userName,String password) throws InterruptedException {
        menuItems.get(1).click();
        btnSubmit.get(2).click();
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        WebElement empID = txtFields.get(4);
        Thread.sleep(1000);
        empID.clear();
        empID.sendKeys(Keys.CONTROL + "a");
        empID.sendKeys(employeeId);
        Thread.sleep(1000);
        toggleButton.click();
        txtFields.get(5).sendKeys(userName); //insert Username
        txtFields.get(6).sendKeys(password); //insert Password
        txtFields.get(7).sendKeys(password); //insert confirm password
        btnSubmit.get(1).click();
    }
}
