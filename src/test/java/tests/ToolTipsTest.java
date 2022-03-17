package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ToolTipsPage;

import java.util.Random;

public class ToolTipsTest extends BaseTest {

    @Test
    public void hoverToButtonTest() {
        ToolTipsPage toolTipsPage = new ToolTipsPage();
        toolTipsPage.open();
        toolTipsPage.hoverToButton();
        Assert.assertEquals(toolTipsPage.getTipMessage(), "You hovered over the Button");
    }

    @Test
    public void hoverToTextFieldTest() {
        ToolTipsPage toolTipsPage = new ToolTipsPage();
        toolTipsPage.open();
        toolTipsPage.hoverToTextField();
        Assert.assertEquals(toolTipsPage.getTipMessage(), "You hovered over the text field");
    }

    @Test
    public void hoverToPartOfText() {
        String[] textParts = {"Contrary", "1.10.32"};
        String randomTextPart = textParts[new Random().nextInt(textParts.length - 1)];
        ToolTipsPage toolTipsPage = new ToolTipsPage();
        toolTipsPage.open();
        toolTipsPage.hoverToPartOfText(randomTextPart);
        Assert.assertEquals(toolTipsPage.getTipMessage(), String.format("You hovered over the %s", randomTextPart));
    }
}
