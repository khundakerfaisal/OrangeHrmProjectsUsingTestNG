package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;


import java.util.List;

public class myInfoPage {
    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> menuItems;

    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdownSelection;
    @FindBy(className = "oxd-button")
    public List<WebElement> btnSubmit;


    public myInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    WebDriver driver;
    public void selectGenderAndBlood(String blood) throws InterruptedException {
        menuItems.get(5).click();
        dropdownSelection.get(2).click();
        dropdownSelection.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        dropdownSelection.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        dropdownSelection.get(2).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        Thread.sleep(1000);
//        bloodDropdown.clear();


        Thread.sleep(1000);


    }
}
