package TestCases;

import AutomationStorePackage.HomePage;
import AutomationStorePackage.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyAccountTestSuite {

    public WebDriver driver;

    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    void tearDown(){
        //Close the browser
        driver.quit();
    }


    @Test
    void loginAndPrintPageTitle(){
        //WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        LoginPage loginPageObj = new LoginPage(driver);
        HomePage homePageObj = new HomePage(driver);


        // And now use this to visit Google
        driver.get("http://automationpractice.com/index.php");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait waiting = new WebDriverWait(driver,5);

        // Click the link
        homePageObj.clickSignOnLink();
        loginPageObj.enterEmail("seleniumdemo@maildrop.cc");
        loginPageObj.enterPassword("SeleniumDemo");
        loginPageObj.clickSignInButton();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
    }
}
