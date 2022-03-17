package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ToolTipsPage {

    public void open() {
        Selenide.open("tool-tips");
    }

    public void hoverToButton() {
        Selenide.actions()
                .moveToElement($("#toolTipButton"))
                .build()
                .perform();
    }

    public void hoverToTextField() {
        Selenide.actions()
                .moveToElement($("#toolTipTextField"))
                .build()
                .perform();
    }

    public void hoverToPartOfText(String textPart) {
        Selenide.actions()
                .moveToElement($x(String.format("//a[text()='%s']", textPart)))
                .build()
                .perform();
    }

    public String getTipMessage() {
        return $(".tooltip-inner").getText();
    }
}
