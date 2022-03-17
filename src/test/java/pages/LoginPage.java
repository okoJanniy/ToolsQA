package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void open() {
        Selenide.open("login");
    }

    public boolean isPageOpened() {
        return $("#userName").shouldBe(Condition.visible).isDisplayed();
    }

    public void login(String userName, String pass) {
        $("#userName").sendKeys(userName);
        $("#password").sendKeys(pass);
        PropertyReader.setProperty("demoqa.button.name", $("#login").getText());
        System.out.println(PropertyReader.getProperty("demoqa.button.name"));
        $("#login").click();
    }

    public void createAccount() {
        $("#newUser").click();
    }
}
