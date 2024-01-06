import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class loginPage {

    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(name = "password")
    WebElement txtPassword;
    @FindBy(className = "oxd-button")
    WebElement btnLogin;

    @FindBy(className = "oxd-userdropdown-name")
    WebElement lblUserName;


    @FindBy(css = "[role=\"menuitem\"]")
    List<WebElement> cblUserMenu;


    public loginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void doLoginWithCred(String username, String password){
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();

    }

    public void doLogout(){
        lblUserName.click();
        cblUserMenu.get(3).click();

    }

}
