package tests;

import models.CheckBoxTitleFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckBoxTest extends BaseTest {

    @Test
    public void CheckboxTestPositive() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        String checkboxTitle = CheckBoxTitleFactory.get();
        checkBoxPage.open();
        checkBoxPage.openAllCheckboxes();
        checkBoxPage.selectFileFromCheckboxList(checkboxTitle);
        Assert.assertTrue(checkBoxPage.isCheckboxSelected(checkboxTitle),
                "Checkbox is not selected or disabled");
    }
}
