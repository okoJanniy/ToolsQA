package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStorePage;

public class BookStoreTest extends BaseTest {

    @Test
    public void searchBookTest() {
        BookStorePage bookStorePage = new BookStorePage();
        bookStorePage.open();
        bookStorePage.findBook("You Don't Know JS");
        Assert.assertTrue(bookStorePage.isThereIsOnlyOneBook());
        Assert.assertEquals(bookStorePage.getBookName(), "You Don't Know JS");
    }
}
