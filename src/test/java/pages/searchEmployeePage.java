package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class searchEmployeePage {

    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> btnMenuItem;
    @FindBy(className = "oxd-topbar-body-nav-tab")
    List<WebElement> btnTabItem;

    @FindBy(className = "oxd-input")
    List<WebElement> txtSearchBox;
    @FindBy(className = "oxd-button")
    List<WebElement> btnSearch;
    public searchEmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchEmployee(String employeeID) throws InterruptedException {
        btnMenuItem.get(1).click();
        Thread.sleep(1000);
        btnTabItem.get(1).click();
        Thread.sleep(1000);
        txtSearchBox.get(1).sendKeys(employeeID);
        Thread.sleep(1000);
        btnSearch.get(1).click();
    }


}
