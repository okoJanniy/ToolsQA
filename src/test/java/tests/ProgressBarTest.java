package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProgressBarPage;

public class ProgressBarTest extends BaseTest {

    @Test
    public void fullProgressBarTest() {
        ProgressBarPage progressBarPage = new ProgressBarPage();
        progressBarPage.open();
        progressBarPage.waitUntilFullComplete();
        Assert.assertEquals(progressBarPage.getProgress(), "100%");
    }

    @Test
    public void halfProgressBarTest() {
        ProgressBarPage progressBarPage = new ProgressBarPage();
        progressBarPage.open();
        progressBarPage.waitUntilHalfComplete();
        Assert.assertEquals(progressBarPage.getProgress(), "50%");
    }
}
