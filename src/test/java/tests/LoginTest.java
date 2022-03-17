package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import utils.PropertyReader;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestPositive() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(PropertyReader.getProperty("demoqa.user"),
                PropertyReader.getProperty("demoqa.pass"));
        Assert.assertTrue(new ProfilePage().isPageOpened());
    }
}
