package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class DragabblePage {

    public void open() {
        Selenide.open("dragabble");
    }

    public void simpleDragBox() {
        Selenide.actions()
                .dragAndDropBy($("#dragBox"), 100, 150)
                .build()
                .perform();
    }

    public void axisXRestrictedBox() {
        $("#draggableExample-tab-axisRestriction").click();
        Selenide.actions()
                .dragAndDropBy($("#restrictedX"), 100, 50)
                .build()
                .perform();
    }

    public void axisYRestrictedBox() {
        $("#draggableExample-tab-axisRestriction").click();
        Selenide.actions()
                .dragAndDropBy($("#restrictedY"), -50, 100)
                .build()
                .perform();
    }

    public void bigContainerRestricted() {
        $("#draggableExample-tab-containerRestriction").click();
        Selenide.actions()
                .dragAndDropBy($("#containmentWrapper>.draggable"), 200, 200)
                .build()
                .perform();
    }

    public void smallContainerRestricted() {
        $("#draggableExample-tab-containerRestriction").click();
        $("body").sendKeys(Keys.PAGE_DOWN);
        Selenide.actions()
                .pause(200)
                .dragAndDropBy($(".ui-widget-header"), 100, 100)
                .build()
                .perform();
    }

    public void cursorStyle() {
        $("#draggableExample-tab-cursorStyle").click();
        Selenide.actions()
                .dragAndDropBy($("#cursorTopLeft"), 100, 100)
                .build()
                .perform();
    }

    public String getSimpleDragBoxPosition() {
        String left = $("#dragBox").getCssValue("left");
        String top = $("#dragBox").getCssValue("top");
        System.out.println($("#dragBox").getLocation().x);
        System.out.println($("#dragBox").getLocation().y);
        return left + " x " + top;
    }

    public String getAxisXRestrictedDragBoxPosition() {
        String left = $("#restrictedX").getCssValue("left");
        String top = $("#restrictedX").getCssValue("top");
        return left + " x " + top;
    }

    public String getAxisYRestrictedDragBoxPosition() {
        String left = $("#restrictedY").getCssValue("left");
        String top = $("#restrictedY").getCssValue("top");
        return left + " x " + top;
    }

    public String getBigContainerRestrictedDragBoxPosition() {
        String left = $("#dragBox").getCssValue("left");
        String top = $("#dragBox").getCssValue("top");
        return left + " x " + top;
    }

    public String getSmallContainerRestrictedDragBoxPosition() {
        String left = $("#dragBox").getCssValue("left");
        String top = $("#dragBox").getCssValue("top");
        return left + " x " + top;
    }
}
