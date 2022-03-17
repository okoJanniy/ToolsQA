package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class DroppablePage {

    public void open() {
        Selenide.open("droppable");
    }

    public void simpleDragAndDrop() {
        Selenide.actions()
                .dragAndDrop($("#draggable"), $(".simple-drop-container>#droppable"))
                .build()
                .perform();
    }

    public void acceptableDragAndDrop() {
        $("#droppableExample-tab-accept").click();
        Selenide.actions()
                .dragAndDrop($("#acceptable"), $(".accept-drop-container>#droppable"))
                .build()
                .perform();
    }

    public void notAcceptableDragAndDrop() {
        $("#droppableExample-tab-accept").click();
        Selenide.actions()
                .dragAndDrop($("#notAcceptable"), $(".accept-drop-container>#droppable"))
                .build()
                .perform();
    }

    public void dragToNotGreedyAndDrop() {
        $("#droppableExample-tab-preventPropogation").click();
        Selenide.actions()
                .dragAndDrop($("#dragBox"), $("#notGreedyInnerDropBox"))
                .build()
                .perform();
    }

    public void dragToGreedyAndDrop() {
        $("#droppableExample-tab-preventPropogation").click();
        Selenide.actions()
                .dragAndDropBy($("#dragBox"), 0, 200)
                .sendKeys(Keys.PAGE_DOWN)
                .pause(600)
                .dragAndDrop($("#dragBox"), $("#greedyDropBoxInner"))
                .build()
                .perform();
    }

    public void dragBoxWillRevert() {
        $("#droppableExample-tab-revertable").click();
        Selenide.actions()
                .dragAndDrop($("#revertable"), $(".revertable-drop-container>#droppable"))
                .pause(600)
                .build()
                .perform();
    }

    public void dragBoxWillNotRevert() {
        $("#droppableExample-tab-revertable").click();
        Selenide.actions()
                .dragAndDrop($("#notRevertable"), $(".revertable-drop-container>#droppable"))
                .build()
                .perform();
    }

    public String getSimpleDroppableBoxMessage() {
        return $(".simple-drop-container>#droppable").getText();
    }

    public String getAcceptableDroppableBoxMessage() {
        return $(".accept-drop-container>#droppable").getText();
    }

    public String getNotGreedyDroppableBoxesMessages() {
        return $("#notGreedyDropBox").getText();
    }

    public String getGreedyDroppableBoxesMessages() {
        return $("#greedyDropBox").getText();
    }

    public String getRevertableDroppableBoxMessage() {
        return $(".revertable-drop-container>#droppable").getText();
    }

    public String getRevertableBoxPosition() {
        String left = $("#revertable").getCssValue("left");
        String top = $("#revertable").getCssValue("top");
        return left + " x " + top;
    }

    public String getNotRevertableBoxPosition() {
        String left = $("#notRevertable").getCssValue("left");
        String top = $("#notRevertable").getCssValue("top");
        return left + " x " + top;
    }
}
