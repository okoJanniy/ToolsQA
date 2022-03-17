package tests;

import models.RadioButtonFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RadioButtonPage;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonTestPositive() {
        RadioButtonPage radioButtonPage = new RadioButtonPage();
        String buttonName = RadioButtonFactory.get();
        radioButtonPage.open();
        radioButtonPage.selectButton(buttonName);
        Assert.assertTrue(radioButtonPage.isButtonSelected(buttonName), "Button is disabled or not selected");
        Assert.assertEquals(radioButtonPage.getSuccessMessage(), buttonName, "Success message is incorrect");
    }
}
