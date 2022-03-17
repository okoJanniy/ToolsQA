package wrappers;

import static com.codeborne.selenide.Selenide.$;

public class Input {
    private final String inputText;

    public Input(String inputText) {
        this.inputText = inputText;
    }

    public void addTextByCssId(String id) {
        $("#" + id).clear();
        $("#" + id).sendKeys(inputText);
    }
}
