package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class DynamicPropertiesPage {

    public void open() {
        Selenide.open("dynamic-properties");
    }

    public boolean isButtonEnabled() {
        return $("#enableAfter").shouldBe(Condition.enabled).isEnabled();
    }

    public boolean isButtonColorChanged() {
        $("#colorChange").shouldBe(Condition.cssValue("color",
                "rgba(220, 53, 69, 1)"));
        return $("#colorChange").getCssValue("color").equals("rgba(220, 53, 69, 1)");

    }

    public boolean isButtonVisible() {
        return $("#visibleAfter").shouldBe(Condition.visible).isDisplayed();
    }
}
