package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxPage {

    public void open() {
        Selenide.open("checkbox");
    }

    public void openAllCheckboxes() {
        $("button[aria-label='Expand all']").click();
    }

    public void collapseAllCheckboxes() {
        $("button[aria-label='Collapse all']").click();
    }

    public void selectFileFromCheckboxList(String checkboxTitle) {
        new CheckBoxPage().selectCheckbox(checkboxTitle);
    }

    public boolean isCheckboxSelected(String checkboxTitle) {
        return new CheckBoxPage().isSelected(checkboxTitle);
    }

    private void selectCheckbox(String title) {
        $x(String.format("//*[contains(text(),'%s')]/ancestor::span[@class='rct-text']" +
                "//*[@class='rct-checkbox']", title)).click();
    }

    private boolean isSelected(String title) {
        return $x(String.format("//*[contains(text(),'%s')]/ancestor::span[@class='rct-text']" +
                "//*[@type='checkbox']", title)).isSelected();
    }
}
