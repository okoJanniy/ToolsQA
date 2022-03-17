package tests;

import models.PracticeForm;
import models.PracticeFormFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTestPositive() {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        PracticeForm userData = PracticeFormFactory.get();
        practiceFormPage.open();
        practiceFormPage.fillForm(userData);
        Assert.assertTrue(practiceFormPage.isDataInFormCorrect(userData));
    }
}
