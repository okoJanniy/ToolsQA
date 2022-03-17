package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class BrowserWindowsPage {

    public void open() {
        Selenide.open("browser-windows");
    }

    public void openNewTab() {
        $("#tabButton").click();
        List<String> browserTabs = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
        Selenide.switchTo().window(browserTabs.get(1));
    }

    public void openNewWindow() {
        $("#windowButton").click();
        List<String> browserWindows = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
        Selenide.switchTo().window(browserWindows.get(1));
    }

    public void openNewWindowMessage() {
        $("#messageWindowButton").click();
        List<String> browserWindows = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
        Selenide.switchTo().window(browserWindows.get(1));
    }

    public String getTextFromBody() {
        return $("body").getText();
    }
}
