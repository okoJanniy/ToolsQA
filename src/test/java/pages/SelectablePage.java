package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectablePage {

    public void open() {
        Selenide.open("selectable");
    }

    public void selectAllListElements() {
        ElementsCollection elementsToBeSelected = $$(".vertical-list-container>.list-group-item");
        elementsToBeSelected.get(elementsToBeSelected.size() - 1).shouldBe(Condition.visible);
        for (int i = 0; i <= elementsToBeSelected.size() - 1; i++) {
            elementsToBeSelected.get(i).click();
        }
    }

    public void selectAllGridElements() {
        $("#demo-tab-grid").click();
        $("body").sendKeys(Keys.ARROW_DOWN);
        ElementsCollection elementsToBeSelected = $$(".grid-container>.list-group>.list-group-item");
        for (int i = 0; i <= elementsToBeSelected.size() - 1; i++) {
            elementsToBeSelected.get(i).click();
        }
    }

    public int getNumOfSelectedListElements() {
        return $$(".vertical-list-container>.active").size();
    }

    public int getNumOfSelectedGridElements() {
        return $$(".grid-container>.list-group>.active").size();
    }
}
