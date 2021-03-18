package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageFactory;
import pages.LoginPageObject;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LoginPageTest extends BaseTest{

    private LoginPageObject loginPage;

    @Before
    public void setUp() {
        loginPage = new LoginPageObject(driver);
    }

    @Test
    public void checkLogin() {
    loginPage.login(System.getProperty("username"),System.getProperty("password"));
    try {
        sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    //loginPage.validateErrorMessage("incorrect username or password");
    }



}
