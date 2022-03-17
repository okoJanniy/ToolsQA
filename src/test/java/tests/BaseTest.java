package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        Configuration.timeout = 6000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        //Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.clickViaJs = true;
    }

    @AfterMethod
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}
