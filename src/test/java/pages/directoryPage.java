package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class directoryPage {

    @FindBy(className = "oxd-text")
    List<WebElement> btnMenuItem;

//    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
//    WebElement txtAutoCompleteInputBox;

    @FindBy(tagName = "input")
    public List<WebElement> txtSearchEmpName;

    @FindBy(className = "oxd-button")
    public List<WebElement> btnSearch;

    public directoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void searchByEmployeeName(String firstName) throws InterruptedException {
        btnMenuItem.get(8).click();
        Thread.sleep(1000);
        txtSearchEmpName.get(1).sendKeys(firstName);

        Thread.sleep(1000);
        btnSearch.get(1).click();
    }
}
