package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SortablePage;

public class SortableTest extends BaseTest {

    @Test
    public void sortableListTest() {
        SortablePage sortablePage = new SortablePage();
        sortablePage.open();
        sortablePage.sortListDesc();
        Assert.assertEquals(sortablePage.getListElements(), "Six\nFive\nFour\nThree\nTwo\nOne");
    }

    @Test
    public void sortableGridTest() {
        SortablePage sortablePage = new SortablePage();
        sortablePage.open();
        sortablePage.sortGridDesc();
        Assert.assertEquals(sortablePage.getGridElements(), "Nine\nEight\nSeven\nSix\nFive\nFour\nThree\nTwo\nOne");
    }
}
