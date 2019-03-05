package AutomationStorePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(css ="#email" )
    WebElement EmailField;

    @FindBy(css ="#passwd" )
    WebElement PasswordField;

    @FindBy(css ="#login_form .button-medium" )
    WebElement SignInButton;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,30);
    }


    public void enterEmail(String email){
        EmailField.sendKeys(email);
    }

    public void enterPassword(String password){
        PasswordField.sendKeys(password);
    }

    public void clickSignInButton (){
        SignInButton.click();
    }

}
