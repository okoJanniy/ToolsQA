package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class AutoCompletePage {

    public void open() {
        Selenide.open("auto-complete");
    }

    public void addMultipleColorNames() {
        $("#autoCompleteMultipleInput").sendKeys("r");
        $("#autoCompleteMultipleInput").sendKeys(Keys.ENTER);
        $("#autoCompleteMultipleInput").sendKeys("g");
        $("#autoCompleteMultipleInput").sendKeys(Keys.ENTER);
        $("#autoCompleteMultipleInput").sendKeys("b");
        $("#autoCompleteMultipleInput").sendKeys(Keys.ENTER);
    }

    public void addSingleColorName() {
        $("#autoCompleteSingleInput").sendKeys("r");
        $("#autoCompleteSingleInput").sendKeys(Keys.ENTER);
    }

    public String getEnteredSingleData() {
        return $(".auto-complete__single-value").getText();
    }

    public String[] getEnteredMultipleData() {
        return $(".auto-complete__value-container").getText().split("\n");
    }

    public boolean isEnteredDataCorrect(String[] data) {
        boolean isEnteredColorsCorrect = true;
        for (String color : data) {
            switch (color) {
                case "Red":
                case "Green":
                case "Blue":
                    break;
                default: isEnteredColorsCorrect = false;
            }
        }
        return isEnteredColorsCorrect;
    }
}
