package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NestedFramePage;

public class NestedFrameTest extends BaseTest {

    @Test
    public void parentFrameTest() {
        NestedFramePage nestedFramePage = new NestedFramePage();
        nestedFramePage.open();
        Assert.assertEquals(nestedFramePage.getParentFrameText(), "Parent frame");
    }

    @Test
    public void childFrameTest() {
        NestedFramePage nestedFramePage = new NestedFramePage();
        nestedFramePage.open();
        Assert.assertEquals(nestedFramePage.getChildFrameText(), "Child Iframe");
    }
}
