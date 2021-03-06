package pages.factory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageFactory {

    private WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;


    @FindBy(name = "password")
    private WebElement passwordField;


    @FindBy(name = "commit")
    private WebElement submitButton;

    @FindBy(css = "div.container-lg.px-2")
    private WebElement errorMessageText;

    public LoginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

    }

    public void validateErrorMessage(String errorMessage){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.textToBePresentInElement(errorMessageText, errorMessage));
        Assert.assertEquals(errorMessage, errorMessageText.getText());
    }




}
