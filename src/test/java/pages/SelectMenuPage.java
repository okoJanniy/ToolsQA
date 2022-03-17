package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SelectMenuPage {
    private final String baseLocator = "//div[@id='selectMenuContainer']";

    public void open() {
        Selenide.open("select-menu");
    }

    public void selectValue() {
        Selenide.actions()
                .moveToElement($("#withOptGroup"))
                .click()
                .build()
                .perform();
        String firstOption = new SelectMenuPage().getRandomOption();
        Selenide.actions()
                .moveToElement($("#withOptGroup"))
                .click()
                .sendKeys(firstOption)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void selectOne() {
        Selenide.actions()
                .moveToElement($("#selectOne"))
                .click()
                .build()
                .perform();
        String firstOption = new SelectMenuPage().getRandomOption();
        Selenide.actions()
                .moveToElement($("#selectOne"))
                .click()
                .sendKeys(firstOption)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }

    public void oldStyleSelectMenu() {
        Select colorSelect = new Select($("#oldSelectMenu"));
        new SelectMenuPage().getRandomStandardSelectOption(colorSelect).click();
    }

    public void multiselectDropDown() {
        $("#react-select-4-input").sendKeys("e");
        String firstOption = new SelectMenuPage().getRandomOption();
        String secondOption = new SelectMenuPage().getRandomOption();
        $("#react-select-4-input").clear();
        $("#react-select-4-input").sendKeys(firstOption);
        $("#react-select-4-input").sendKeys(Keys.ENTER);
        $("#react-select-4-input").sendKeys(secondOption);
        $("#react-select-4-input").sendKeys(Keys.ENTER);
    }

    public void standardMultiSelect() {
        Select carSelect = new Select($("#cars"));
        new SelectMenuPage().getRandomStandardSelectOption(carSelect).click();
    }

    private WebElement getRandomStandardSelectOption(Select select) {
        return select.getOptions().get(new Random().nextInt(select.getOptions().size() - 1));
    }

    private String getRandomOption() {
        String[] options = $x(baseLocator + "//div[contains(@class,'menu')]").
                getText().split("\n");
        return options[new Random().nextInt(options.length - 1)];
    }
}
