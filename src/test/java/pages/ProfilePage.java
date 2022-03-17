package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {

    public boolean isPageOpened() {
        return $x("//button[text()='Log out']").shouldBe(Condition.visible).isDisplayed();
    }

    public void logout() {
        $x("//button[text()='Log out']").click();
    }

    public void openBookStore() {
        $("#gotoStore").click();
    }
}
