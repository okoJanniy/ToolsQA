package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IframePage;

public class IframeTest extends BaseTest {

    @Test
    public void bigIframeTest() {
        IframePage iframePage = new IframePage();
        iframePage.open();
        Assert.assertEquals(iframePage.getTextFromFirstIframe(), "This is a sample page");
    }

    @Test
    public void smallIframeTest() {
        IframePage iframePage = new IframePage();
        iframePage.open();
        Assert.assertEquals(iframePage.getTextFromSecondIframe(), "This is a sample page");
    }
}
