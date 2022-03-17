package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrokenLinksPage;

public class BrokenLinksTest extends BaseTest {

    @Test
    public void pictureTest() {
        BrokenLinksPage brokenLinks = new BrokenLinksPage();
        brokenLinks.open();
        Assert.assertTrue(brokenLinks.isAnyImageBroken());
        Assert.assertEquals(brokenLinks.getNameOfBrokenImage(), "https://demoqa.com/images/Toolsqa_1.jpg",
                "Some other image is broken");
    }

    @Test
    public void validLinkTest() {
        BrokenLinksPage brokenLinks = new BrokenLinksPage();
        brokenLinks.open();
        brokenLinks.clickValidLink();
        Assert.assertEquals(brokenLinks.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void brokenLinkTest() {
        BrokenLinksPage brokenLinks = new BrokenLinksPage();
        brokenLinks.open();
        brokenLinks.clickBrokenLink();
        Assert.assertEquals(brokenLinks.getCurrentUrl(),
                "http://the-internet.herokuapp.com/status_codes/500");
    }
}
