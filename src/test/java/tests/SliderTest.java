package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SliderPage;

public class SliderTest extends BaseTest {

    @Test
    public void sliderTestPositive() {
        SliderPage sliderPage = new SliderPage();
        sliderPage.open();
        sliderPage.dragSliderTo85();
        Assert.assertEquals(sliderPage.getSliderValue(), "85");
    }
}
