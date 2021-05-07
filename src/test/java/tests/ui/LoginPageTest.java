package tests.ui;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;

import static java.lang.System.getProperty;
import static java.lang.Thread.sleep;

public class LoginPageTest extends BaseTest{


    private LoginPage loginPage;
    private final static Logger LOG = LogManager.getLogger("Версия селениума");


    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @DisplayName("BLA4")
    @Test
    public void checkLogin(){
        loginPage.login(System.getProperty("username"),System.getProperty("password"));
        //  loginPage.validateErrorMessage("Incorrect username or password.");
    }


    @DisplayName("BLA3")
    @Test
    public void checkSeleniumVersion(){
        loginPage.login(System.getProperty("username"),System.getProperty("password"));
        driver.findElement(By.xpath("//span[contains(text(), 'G48Automation')]")).click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("pom.xml")).click();
        LOG.info(loginPage.getVersionSelenium());
        Assert.assertEquals(loginPage.getVersionSelenium(),"3.141.59");
    }

    @DisplayName("BLA 2")
    @Test
    public void checkNegativeLogin(){
        loginPage.login("admin","admin");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

//    @Description("Нужно чтобы показыать последнее сообщение коммита")
//    @TmsLink("Ссылка на тест кейс")
//    @Issue("тут указать сылку на баг - удобно для регресии")
//    @Feature("?????")
//    @Story("????")
//    @Owner("тот кто писал")
//    @Severity(SeverityLevel.CRITICAL)//уровень важности
    @DisplayName("BLA BLA BLA")
    @Test
    public void showCommitMessageTest(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }





}
