package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public class MenuPage {

    public void open() {
        Selenide.open("menu");
    }

    public void hoverToSubItem() {
        Selenide.actions()
                .moveToElement($x("//a[text()='Main Item 2']"))
                .moveToElement($x("//a[text()='Sub Item']"))
                .build()
                .perform();
    }

    public void hoverToSubSubList() {
        Selenide.actions()
                .moveToElement($x("//a[text()='Main Item 2']"))
                .moveToElement($x("//a[text()='SUB SUB LIST »']"))
                .build()
                .perform();
    }

    public boolean isItemDisplayed(String itemName) {
        return $x(String.format("//a[text()='%s']", itemName)).isDisplayed();
    }
}
