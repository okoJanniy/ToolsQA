package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SelectablePage;

public class SelectableTest extends BaseTest {

    @Test
    public void selectableListTest() {
        SelectablePage selectablePage = new SelectablePage();
        selectablePage.open();
        selectablePage.selectAllListElements();
        Assert.assertEquals(selectablePage.getNumOfSelectedListElements(), 4);
    }

    @Test
    public void selectableGridTest() {
        SelectablePage selectablePage = new SelectablePage();
        selectablePage.open();
        selectablePage.selectAllGridElements();
        Assert.assertEquals(selectablePage.getNumOfSelectedGridElements(), 9);
    }
}
