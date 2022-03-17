package tests;

import models.WebTableUser;
import models.WebTableUserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebTablesPage;

public class WebTablesTest extends  BaseTest {

    @Test
    public void addUserTest() {
        WebTablesPage webTablesPage = new WebTablesPage();
        WebTableUser userData = WebTableUserFactory.get();
        webTablesPage.open();
        webTablesPage.addNewUser(userData);
        Assert.assertTrue(webTablesPage.isUserDataCorrect(userData),
                "Some user data wasn't saved correctly");
    }

    @Test
    public void editUserTest() {
        WebTablesPage webTablesPage = new WebTablesPage();
        WebTableUser userData = WebTableUserFactory.get();
        WebTableUser newUserData = WebTableUserFactory.get();
        webTablesPage.open();
        webTablesPage.addNewUser(userData);
        Assert.assertTrue(webTablesPage.isUserDataCorrect(userData),
                "Some user data wasn't saved correctly");
        webTablesPage.editUser(userData, newUserData);
        Assert.assertTrue(webTablesPage.isUserDataCorrect(newUserData),
                "Some user data wasn't changed correctly");
    }

    @Test
    public void deleteUserTest() {
        WebTablesPage webTablesPage = new WebTablesPage();
        WebTableUser userData = WebTableUserFactory.get();
        webTablesPage.open();
        webTablesPage.addNewUser(userData);
        webTablesPage.deleteUser(userData);
        Assert.assertFalse(webTablesPage.isUserExists(userData), "User has not been deleted");
    }

    @Test
    public void searchUserTest() {
        WebTablesPage webTablesPage = new WebTablesPage();
        WebTableUser userData = WebTableUserFactory.get();
        webTablesPage.open();
        webTablesPage.addNewUser(userData);
        webTablesPage.findUser(userData);
        Assert.assertEquals(webTablesPage.numOfUsers(), 1, "Search is not working");
    }
}
