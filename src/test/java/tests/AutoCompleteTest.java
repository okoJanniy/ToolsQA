package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoCompletePage;

public class AutoCompleteTest extends BaseTest {

    @Test
    public void multipleColorNamesTest() {
        AutoCompletePage autoCompletePage = new AutoCompletePage();
        autoCompletePage.open();
        autoCompletePage.addMultipleColorNames();
        String[] enteredData = autoCompletePage.getEnteredMultipleData();
        Assert.assertTrue(enteredData.length >= 1);
        Assert.assertTrue(autoCompletePage.isEnteredDataCorrect(enteredData));
    }

    @Test
    public void singleColorNameTest() {
        AutoCompletePage autoCompletePage = new AutoCompletePage();
        autoCompletePage.open();
        autoCompletePage.addSingleColorName();
        String[] enteredData = {autoCompletePage.getEnteredSingleData()};
        Assert.assertTrue(autoCompletePage.isEnteredDataCorrect(enteredData));
    }
}
