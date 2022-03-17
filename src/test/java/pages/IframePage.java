package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class IframePage {

    public void open() {
        Selenide.open("frames");
    }

    public String getTextFromFirstIframe() {
        Selenide.switchTo().innerFrame("frame1");
        return $("body").getText();
    }

    public String getTextFromSecondIframe() {
        Selenide.switchTo().innerFrame("frame2");
        return $("body").getText();
    }
}
