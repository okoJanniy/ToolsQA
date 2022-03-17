package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;

public class ButtonsTest extends BaseTest {

    @Test
    public void doubleClickTest() {
        ButtonsPage buttonsPage = new ButtonsPage();
        buttonsPage.open();
        buttonsPage.doubleClickButton();
        Assert.assertEquals(buttonsPage.getSuccessDoubleClickMessage(), "You have done a double click");
    }

    @Test
    public void rightClickTest() {
        ButtonsPage buttonsPage = new ButtonsPage();
        buttonsPage.open();
        buttonsPage.rightClickButton();
        Assert.assertEquals(buttonsPage.getSuccessRightClickMessage(), "You have done a right click");
    }

    @Test
    public void clickTest() {
        ButtonsPage buttonsPage = new ButtonsPage();
        buttonsPage.open();
        buttonsPage.leftClickButton();
        Assert.assertEquals(buttonsPage.getSuccessLeftClickMessage(), "You have done a dynamic click");
    }
}
