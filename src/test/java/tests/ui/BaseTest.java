
package tests.ui;

import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;


    @Rule
    public TestWatcher watcher = new TestWatcher() {

        @Attachment(value = "Failed screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenshotAsBytes){
            return screenshotAsBytes;
        }

        @Override
        protected void failed(Throwable e, Description description) {
            if (driver != null){
                saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
            super.failed(e, description);
        }

        /*
        @Override
      //  @Step("Закрываем драйвер после тестирования")
        protected void finished(Description description) {
            if (driver != null){
                driver.quit();
            }
        }
         */

    };





///not right
    @Before
    public void init(){
        String browserName = System.getProperty("browser", "chrome");
        System.getProperty("remote.launch", "true").equals("true");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("Chromedriver");
        capabilities.setCapability("version", System.getProperty("browser.version"));
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        try {
            this.driver = new RemoteWebDriver(new URL("htt"), capabilities);
        } catch (MalformedURLException ignored) {
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("");






//        switch (browserName){
//            case "firefox":
//                this.driver = new FirefoxDriver();
//                break;
//            case "opera":
//                this.driver = new OperaDriver();
//                break;
//            default:
//                this.driver = new ChromeDriver();
//                break;
//        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://github.com/login");
    }










    @After
    public void exit(){
        driver.quit();
    }


}