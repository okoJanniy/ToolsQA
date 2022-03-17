package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicPropertiesPage;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void buttonEnabledTest() {
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();
        dynamicPropertiesPage.open();
        Assert.assertTrue(dynamicPropertiesPage.isButtonEnabled());
    }

    @Test
    public void buttonColorTest() {
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();
        dynamicPropertiesPage.open();
        Assert.assertTrue(dynamicPropertiesPage.isButtonColorChanged());
    }

    @Test
    public void buttonIsVisibleTest() {
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();
        dynamicPropertiesPage.open();
        Assert.assertTrue(dynamicPropertiesPage.isButtonVisible());
    }
}
