package pages;

import com.codeborne.selenide.Selenide;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class TabsPage {

    public void open() {
        Selenide.open("tabs");
    }

    public void switchTab(String tabName) {
        if (Objects.equals($(String.format("#demo-tab-%s", tabName.toLowerCase())).
                getAttribute("aria-selected"), "false")) {
            $(String.format("#demo-tab-%s", tabName.toLowerCase())).click();
        }
    }

    public boolean isTabPanelTextVisible(String tabName) {
        return $(String.format("#demo-tabpane-%s", tabName.toLowerCase())).isDisplayed();
    }
}
