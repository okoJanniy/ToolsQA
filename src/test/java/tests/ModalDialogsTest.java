package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ModalDialogsPage;

public class ModalDialogsTest extends BaseTest {

    @Test
    public void smallModalDialogTest() {
        ModalDialogsPage modalDialogsPage = new ModalDialogsPage();
        modalDialogsPage.open();
        modalDialogsPage.openSmallModalDialog();
        Assert.assertEquals(modalDialogsPage.getTitleName(), "Small Modal");
    }

    @Test
    public void largeModalDialogTest() {
        ModalDialogsPage modalDialogsPage = new ModalDialogsPage();
        modalDialogsPage.open();
        modalDialogsPage.openLargeModalDialog();
        Assert.assertEquals(modalDialogsPage.getTitleName(), "Large Modal");
    }
}
