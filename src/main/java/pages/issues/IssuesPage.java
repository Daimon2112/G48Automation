package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseProjectPage;

public class IssuesPage extends BaseProjectPage {

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    private final By newIssueButton = By.xpath("//span[text() = 'New issue']");

    public pages.issues.IssueCreationPage openCreationPage(){
        driver.findElement(newIssueButton).click();
        return new pages.issues.IssueCreationPage(driver);
    }
}