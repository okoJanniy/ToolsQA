package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class LinksPage {

    public void open() {
        Selenide.open("links");
    }

    public void linkOpenNewTab() {
        $("#simpleLink").click();
        List<String> browserTabs = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
        Selenide.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://demoqa.com/");
        Selenide.switchTo().window(browserTabs.get(0));
    }

    public void dynamicLinkOpenNewTab() {
        $("#dynamicLink").click();
        List<String> browserTabs = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
        Selenide.switchTo().window(browserTabs.get(1));
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://demoqa.com/");
        Selenide.switchTo().window(browserTabs.get(0));
    }

    public void createResponseLink() {
        $("#created").click();
    }

    public void noContentResponseLink() {
        $("#no-content").click();
    }

    public void movedResponseLink() {
        $("#moved").click();
    }

    public void badRequestResponseLink() {
        $("#bad-request").click();
    }

    public void unauthorizedResponseLink() {
        $("#unauthorized").click();
    }

    public void forbiddenResponseLink() {
        $("#forbidden").click();
    }

    public void notFoundResponseLink() {
        $("#invalid-url").click();
    }

    public String getResponseMessage() {
        return $("#linkResponse").getText();
    }
}
