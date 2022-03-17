package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$$;

public class BrokenLinksPage {

    public void open() {
        Selenide.open("broken");
    }

    public boolean isAnyImageBroken() {
        boolean somethingBroken = false;
        for (SelenideElement a: $$("img")) {
            if (Objects.equals(a.getAttribute("naturalWidth"), "0")) {
                somethingBroken = true;
            }
        }
        return somethingBroken;
    }

    public String getNameOfBrokenImage() {
        String brokenImageSrc = "";
        for (SelenideElement a: $$("img")) {
            if (Objects.equals(a.getAttribute("naturalWidth"), "0")) {
                brokenImageSrc = a.getAttribute("src");
            }
        }
        return brokenImageSrc;
    }

    public void clickValidLink() {
        $$("a").find(Condition.text("Click Here for Valid Link")).click();
    }

    public void clickBrokenLink() {
        $$("a").find(Condition.text("Click Here for Broken Link")).click();
    }

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
