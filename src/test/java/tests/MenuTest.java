package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MenuPage;

public class MenuTest extends BaseTest {

    @Test
    public void subItemTest() {
        MenuPage menuPage = new MenuPage();
        menuPage.open();
        menuPage.hoverToSubItem();
        Assert.assertTrue(menuPage.isItemDisplayed("Sub Item"),
                "Sub item not displayed");
    }

    @Test
    public void subSubListTest() {
        MenuPage menuPage = new MenuPage();
        menuPage.open();
        menuPage.hoverToSubSubList();
        Assert.assertTrue(menuPage.isItemDisplayed("Sub Sub Item 1"),
                "Sub sub items not displayed");
    }
}
