package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class BookStorePage {

    public void open() {
        Selenide.open("books");
    }

    public void findBook(String bookName) {
        $("#searchBox").sendKeys(bookName);
    }

    public boolean isThereIsOnlyOneBook() {
        return $$("img[alt=image]").size() == 1;
    }

    public String getBookName() {
        return $x("//span[contains(@id,'see-book')]").getText();
    }
}
