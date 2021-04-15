package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.code.CodePage;
import pages.issues.IssueInfoPage;

import java.util.List;

public class ProjectPage extends BasePage {

    private static final String title = "Список задач";

//    public By Code = By.xpath("//span[@data-content = 'Code']");
//    public By Issues = By.xpath("//span[@data-content = 'Issues']");
//    public By pullRequests = By.xpath("//span[@data-content = 'Pull requests']");
//    public By action = By.xpath("//span[@data-content = 'Actions']");
//    public By projects = By.xpath("//span[@data-content = 'Projects']");
//    public By wiki = By.xpath("//span[@data-content = 'Wiki']");
//    public By security = By.xpath("//span[@data-content = 'Security']");
//    public By insights = By.xpath("//span[@data-content = 'Insights']");
//    public By settings = By.xpath("//span[@data-content = 'Settings']");




    public ProjectPage(WebDriver driver) {
        super(driver, title);
    }

    public ProjectPage displayedTab(By tabs){
        driver.findElements(tabs).forEach(tab -> LOG.info("Tab: " + tab.getText()));
        return new ProjectPage(driver);
    }


}
