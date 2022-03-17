package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SortablePage {

    public void open() {
        Selenide.open("sortable");
    }

    public void sortListDesc() {
        $("body").sendKeys(Keys.ARROW_DOWN);
        ElementsCollection sortableElements = $$(".vertical-list-container>.list-group-item");
        sortableElements.get(sortableElements.size() - 1).shouldBe(Condition.visible);
        for (int i = sortableElements.size() - 1; i >= 0; i--) {
            sortableElements = $$(".vertical-list-container>.list-group-item");
            Selenide.actions()
                    .dragAndDrop(sortableElements.get(0), sortableElements.get(i))
                    .build()
                    .perform();
        }
    }

    public void sortGridDesc() {
        $("#demo-tab-grid").click();
        ElementsCollection sortableElements = $$(".create-grid>.list-group-item");
        $("body").sendKeys(Keys.ARROW_DOWN);
        for (int i = sortableElements.size() - 1; i >= 0; i--) {
            sortableElements = $$(".create-grid>.list-group-item");
            Selenide.actions()
                    .dragAndDrop(sortableElements.get(0), sortableElements.get(i))
                    .build()
                    .perform();
        }
    }

    public String getListElements() {
        return $(".vertical-list-container").getText();
    }

    public String getGridElements() {
        return $(".create-grid").getText();
    }
}
