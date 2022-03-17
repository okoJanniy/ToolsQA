package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;

public class AlertsPage {

    public void open() {
        Selenide.open("alerts");
    }

    public String getAlertMessage() {
        $("#alertButton").click();
        return Selenide.switchTo().alert().getText();
    }

    public String getTimerAlertMessage() {
        $("#timerAlertButton").click();
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 10);
        wait.until(ExpectedConditions.alertIsPresent());
        return Selenide.switchTo().alert().getText();
    }

    public void confirmAlertMessage() {
        $("#confirmButton").click();
        Selenide.switchTo().alert().accept();
    }

    public void addTextToAlertMessage(String text) {
        $("#promtButton").click();
        Selenide.switchTo().alert().sendKeys(text);
    }

    public String getSuccessMessage() {
        return $(".text-success").getText();
    }
}
