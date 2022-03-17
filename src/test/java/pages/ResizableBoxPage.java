package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class ResizableBoxPage {

    public void open() {
        Selenide.open("resizable");
    }

    public void resizeToMinSize() {
        Selenide.actions()
                .dragAndDropBy($("#resizableBoxWithRestriction>.react-resizable-handle"),
                        -50, -50)
                .build()
                .perform();
    }

    public void resizeToMaxSize() {
        Selenide.actions()
                .dragAndDropBy($("#resizableBoxWithRestriction>.react-resizable-handle"),
                        300, 100)
                .build()
                .perform();
    }

    public String getSizeOfBox() {
        String boxWidth = $("#resizableBoxWithRestriction").getCssValue("width");
        String boxHeight = $("#resizableBoxWithRestriction").getCssValue("height");
        return boxWidth + " x " + boxHeight;
    }
}
