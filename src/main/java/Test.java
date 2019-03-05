import AutomationStorePackage.HomePage;
import AutomationStorePackage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args){

        //System.setProperty("webdriver.chrome.driver","C:\\GenricDrivers\\chromedriver_win32\\chromedriver.exe");
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        LoginPage loginPageObj = new LoginPage(driver);
        HomePage homePageObj = new HomePage(driver);


        // And now use this to visit Google
        driver.get("http://automationpractice.com/index.php");

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebDriverWait waiting = new WebDriverWait(driver,5);

        // Click the link
        homePageObj.clickSignOnLink();
        loginPageObj.enterEmail("seleniumdemo@maildrop.cc");
        loginPageObj.enterPassword("SeleniumDemo");
        loginPageObj.clickSignInButton();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
/*
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
*/


        //Close the browser
        //driver.quit();
    }
}
