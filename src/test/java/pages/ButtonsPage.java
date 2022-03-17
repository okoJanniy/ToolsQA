package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ButtonsPage {

    public void open() {
        Selenide.open("buttons");
    }

    public void doubleClickButton() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions
                .doubleClick($("#doubleClickBtn"))
                .build()
                .perform();
    }

    public String getSuccessDoubleClickMessage() {
        return $("#doubleClickMessage").getText();
    }

    public void rightClickButton() {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions
                .contextClick($("#rightClickBtn"))
                .build()
                .perform();
    }

    public String getSuccessRightClickMessage() {
        return $("#rightClickMessage").getText();
    }

    public void leftClickButton() {
        $x("//button[text()='Click Me']").click();
    }

    public String getSuccessLeftClickMessage() {
        return $("#dynamicClickMessage").getText();
    }
}
