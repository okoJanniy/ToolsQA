package pages;

import com.codeborne.selenide.Selenide;
import models.TextBox;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage {

    public void open() {
        Selenide.open("text-box");
    }

    public void fillForm(TextBox formData) {
        $("#userName").sendKeys(formData.getName());
        $("#userEmail").sendKeys(formData.getMail());
        $("#currentAddress").sendKeys(formData.getCurAddress());
        $("#permanentAddress").sendKeys(formData.getPermAddress(), Keys.PAGE_DOWN);
        $("#submit").click();
    }

    public String getCreatedName() {
        String[] createdName = $("p#name").getText().split(":");
        return createdName[1];
    }

    public String getCreatedMail() {
        String[] createdMail = $("p#email").getText().split(":");
        return createdMail[1];
    }

    public String getCreatedCurAddress() {
        String[] createdCurAddress = $("p#currentAddress").getText().split(":");
        return createdCurAddress[1];
    }

    public String getCreatedPermAddress() {
        String[] createdPermAddress = $("p#permanentAddress").getText().split(":");
        return createdPermAddress[1];
    }
}
