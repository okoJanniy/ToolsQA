package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;

public class BrowserWindowsTest extends BaseTest {

    @Test
    public void openNewTabTest() {
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.open();
        browserWindowsPage.openNewTab();
        Assert.assertEquals(browserWindowsPage.getTextFromBody(), "This is a sample page");
    }

    @Test
    public void openNewWindowTest() {
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.open();
        browserWindowsPage.openNewWindow();
        Assert.assertEquals(browserWindowsPage.getTextFromBody(), "This is a sample page");
    }

    /**
     * browserWindowsPage.getTextFromBody() doesn't work at new window message test
     */
    @Test
    public void openNewWindowMessageTest() {
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        browserWindowsPage.open();
        browserWindowsPage.openNewWindowMessage();
        Assert.assertEquals(browserWindowsPage.getTextFromBody(),
                "Knowledge increases by sharing but not by saving. " +
                        "Please share this website with your friends and in your organization.");
    }
}
