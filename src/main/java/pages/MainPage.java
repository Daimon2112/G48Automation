package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.CodePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MainPage extends BaseAuthorizedPage{

    private static final String title = "Основная страница приложения";
    public MainPage(WebDriver driver) {
        super(driver, title);
    }

    private By repositoryLink = By.xpath("//span[@title = 'G48Automation']");

    public CodePage openProjectG48(){
        waitFor25.until(elementToBeClickable(repositoryLink)).click();
        return new CodePage(driver);
    }


}