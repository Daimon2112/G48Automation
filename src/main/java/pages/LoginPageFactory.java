package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    @FindBy(name = "login")
    private WebElement loginField;


    @FindBy(name = "password")
    private WebElement passwordField;


    @FindBy(name = "commit")
    private WebElement submitButton;

    @FindBy(css = "div.container-lg.px-2")
    private WebElement errorMessageText;

    public LoginPageFactory(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

    }

    public void validateErrorMessage(String errorMessage){
        Assert.assertEquals(errorMessage, errorMessageText.getText());
    }




}
