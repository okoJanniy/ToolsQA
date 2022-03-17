package tests;

import org.testng.annotations.Test;
import pages.SelectMenuPage;

public class SelectMenuTest extends BaseTest {

    @Test
    public void selectMenuTest() {
        SelectMenuPage selectMenuPage = new SelectMenuPage();
        selectMenuPage.open();
        selectMenuPage.selectValue();
        selectMenuPage.selectOne();
        selectMenuPage.oldStyleSelectMenu();
        selectMenuPage.multiselectDropDown();
        selectMenuPage.standardMultiSelect();
    }
}
