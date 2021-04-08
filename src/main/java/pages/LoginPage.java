
package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By loginField = By.name("login");
    private final By passwordField = By.name("password");
    private final By submitButton = By.name("commit");
    private final By errorMessageText = By.xpath("//div[@class = 'flash flash-full flash-error']/div");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String username, String password){
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return new MainPage(driver);
    }

    public String getVersionSelenium(){
        return driver.findElement(By.xpath("//td[@id ='LC20']")).getText().replaceAll("<version>","").replaceAll("</version>","").replaceAll("    ","");
    }
    public LoginPage validateErrorMessage(String errorMessage){
        waitFor25.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessageText)));
        Assert.assertEquals(errorMessage, driver.findElement(errorMessageText).getText());
        return this;
    }

    public void displayedTab(By element){
        LOG.info(driver.findElement(element).getText());
    }

//LOG.info(driver.findElements(commitMessageText).get(0).getText());

}
