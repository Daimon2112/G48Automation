package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By homePageTitle = By.xpath("//h1");

    public void checkIsLogOut(){
        waitFor25.until(ExpectedConditions.visibilityOf(driver.findElement(homePageTitle)));
    }

    public void fieldFfindRepository(String searchtext){
        driver.findElement(By.id("dashboard-repos-filter-left")).click();
        driver.findElement(By.id("dashboard-repos-filter-left")).sendKeys(searchtext);
    }

    public void fieldSearchOrJumpTo(String searchproject){
        driver.findElement(By.xpath("//input[@aria-controls ='jump-to-results']")).click();
        driver.findElement(By.xpath("//input[@aria-controls ='jump-to-results']")).sendKeys(searchproject);
    }

}