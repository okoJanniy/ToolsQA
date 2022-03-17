package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$x;

public class AccordianPage {

    private final String cardHeaderLocator = "//div[text()='%s']";
    private final String cardBodyLocator = "//div[text()='%s']/ancestor::div[@class='card']" +
            "//div[@class='card-body']";

    public void open() {
        Selenide.open("accordian");
    }

    public void openCard(String headerName) {
        if (!$x(String.format(cardBodyLocator, headerName)).isDisplayed()) {
            $x(String.format(cardHeaderLocator, headerName)).click();
        }
    }

    public boolean isContentVisible(String headerName) {
        return $x(String.format(cardBodyLocator, headerName)).isDisplayed();
    }
}
