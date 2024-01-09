package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void selectGenderAndBlood() throws InterruptedException {
        menuItems.get(5).click();

//        radioButton.click();
////        radioButton.sendKeys(gender);
//        Thread.sleep(1000);
//        btnSubmit.get(0).click();
//        Utils.scrollPage(driver);
//        Thread.sleep(1000);
//        dropdownSelection.get(2).click();
//        dropdownSelection.get(2).sendKeys("O+");
//        Thread.sleep(1000);
//        btnSubmit.get(1).click();

    }
}
