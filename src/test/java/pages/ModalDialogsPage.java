package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class ModalDialogsPage {

    public void open() {
        Selenide.open("modal-dialogs");
    }

    public void openSmallModalDialog() {
        $("#showSmallModal").click();
    }

    public void openLargeModalDialog() {
        $("#showLargeModal").click();
    }

    public String getTitleName() {
        return $(".modal-title").getText();
    }
}
