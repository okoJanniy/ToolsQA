package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ResizableBoxPage;

public class ResizableBoxTest extends BaseTest {

    @Test
    public void resizeToMinTest() {
        ResizableBoxPage resizableBoxPage = new ResizableBoxPage();
        resizableBoxPage.open();
        resizableBoxPage.resizeToMinSize();
        Assert.assertEquals(resizableBoxPage.getSizeOfBox(), "150px x 150px");
    }

    @Test
    public void resizeToMaxTest() {
        ResizableBoxPage resizableBoxPage = new ResizableBoxPage();
        resizableBoxPage.open();
        resizableBoxPage.resizeToMaxSize();
        Assert.assertEquals(resizableBoxPage.getSizeOfBox(), "500px x 300px");
    }
}
