package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class NestedFramePage {

    public void open() {
        Selenide.open("nestedframes");
    }

    public String getParentFrameText() {
        Selenide.switchTo().innerFrame("frame1");
        return $("body").getText();
    }

    public String getChildFrameText() {
        Selenide.switchTo().innerFrame("frame1");
        Selenide.switchTo().frame($("iframe"));
        return $("body").getText();
    }
}
