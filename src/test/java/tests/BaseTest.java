package tests;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageObject;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    public void init() {
        //System.setProperty("WebdriverChrome", System.getProperty("user.dir") + "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://github.com/login");

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
