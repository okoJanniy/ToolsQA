package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;

public class ProgressBarPage {

    public void open() {
        Selenide.open("progress-bar");
    }

    public void waitUntilFullComplete() {
        $("#startStopButton").click();
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 15);
        wait.until(ExpectedConditions.attributeToBe($(".progress-bar"),
                "aria-valuenow", "100"));
    }

    public void waitUntilHalfComplete() {
        $("#startStopButton").click();
        $(".progress-bar").shouldBe(Condition.attribute("aria-valuenow",
                "50"));
        $("#startStopButton").click();
    }

    public String getProgress() {
        return $(".progress-bar").getText();
    }
}
