package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RadioButtonPage {
    private final String radioButtonLocator = "//label[text()='%s']/ancestor::div//*[@id='%sRadio']";

    public void open() {
        Selenide.open("radio-button");
    }

    public void selectButton(String buttonName) {
        String buttonLocator = String.format(radioButtonLocator, buttonName, buttonName.toLowerCase());
        if ($x(buttonLocator).isEnabled()) {
            $x(buttonLocator).click();
        }
    }

    public boolean isButtonSelected(String buttonName) {
        return $x(String.format(radioButtonLocator, buttonName, buttonName.toLowerCase())).isSelected();
    }

    public String getSuccessMessage() {
        return $(".text-success").getText();
    }
}
