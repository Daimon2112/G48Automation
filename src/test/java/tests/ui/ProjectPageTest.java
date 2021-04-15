package tests.ui;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ProjectPage;


import static java.lang.System.getProperty;

public class ProjectPageTest extends BaseTest {

    private LoginPage loginPage;
    public ProjectPage projectPage;
//    public By Code = By.xpath("//span[@data-content = 'Code']");
//    public By Issues = By.xpath("//span[@data-content = 'Issues']");
//    public By pullRequests = By.xpath("//span[@data-content = 'Pull requests']");
//    public By action = By.xpath("//span[@data-content = 'Actions']");
//    public By projects = By.xpath("//span[@data-content = 'Projects']");
//    public By wiki = By.xpath("//span[@data-content = 'Wiki']");
//    public By security = By.xpath("//span[@data-content = 'Security']");
//    public By insights = By.xpath("//span[@data-content = 'Insights']");
//    public By settings = By.xpath("//span[@data-content = 'Settings']");
      public By tabs = By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li");

    @Before
    public void setUp(){
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);
    }

//    @Test
//    public void displayedAllTabs(){
//        loginPage.login(getProperty("username"), getProperty("password"))
//                .openProjectG48();
//        projectPage.displayedTab(Code);
//        projectPage.displayedTab(Issues);
//        projectPage.displayedTab(pullRequests);
//        projectPage.displayedTab(action);
//        projectPage.displayedTab(projects);
//        projectPage.displayedTab(wiki);
//        projectPage.displayedTab(security);
//        projectPage.displayedTab(insights);
//        projectPage.displayedTab(settings);
//    }

    @Test
    public void displayedAllTabs(){
        loginPage.login(getProperty("username"), getProperty("password"))
                .openProjectG48()
                .displayedTab(tabs)
                .logout();

    }
}
