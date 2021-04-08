package tests.ui;

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
    public By Code = By.xpath("//span[@data-content = 'Code']");
    public By Issues = By.xpath("//span[@data-content = 'Issues']");
    public By pullRequests = By.xpath("//span[@data-content = 'Pull requests']");
    public By action = By.xpath("//span[@data-content = 'Actions']");
    public By projects = By.xpath("//span[@data-content = 'Projects']");
    public By wiki = By.xpath("//span[@data-content = 'Wiki']");
    public By security = By.xpath("//span[@data-content = 'Security']");
    public By insights = By.xpath("//span[@data-content = 'Insights']");
    public By settings = By.xpath("//span[@data-content = 'Settings']");

    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkLogin(){
        loginPage.login(System.getProperty("username"),System.getProperty("password"));
        //  loginPage.validateErrorMessage("Incorrect username or password.");
    }

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

    @Test
    public void checkNegativeLogin(){
        loginPage.login("admin","admin");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

    @Test
    public void showCommitMessageTest(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }

    @Test
    public void displayedAllTabs(){
        loginPage.login(getProperty("username"), getProperty("password"))
                .openProjectG48();
        loginPage.displayedTab(Code);
        loginPage.displayedTab(Issues);
        loginPage.displayedTab(pullRequests);
        loginPage.displayedTab(action);
        loginPage.displayedTab(projects);
        loginPage.displayedTab(wiki);
        loginPage.displayedTab(security);
        loginPage.displayedTab(insights);
        loginPage.displayedTab(settings);
    }



}
