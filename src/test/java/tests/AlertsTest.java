package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTest extends BaseTest {

    @Test
    public void alertTest() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.open();
        Assert.assertEquals(alertsPage.getAlertMessage(), "You clicked a button");
    }

    @Test
    public void timerAlertTest() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.open();
        Assert.assertEquals(alertsPage.getTimerAlertMessage(), "This alert appeared after 5 seconds");
    }

    @Test
    public void alertMessageWithConfirmationTest() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.open();
        alertsPage.confirmAlertMessage();
        Assert.assertTrue(alertsPage.getSuccessMessage().contains("Ok"));
    }

    @Test
    public void alertMessageWithInputTest() {
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.open();
        alertsPage.addTextToAlertMessage("Hello world");
        Assert.assertTrue(alertsPage.getSuccessMessage().contains("Hello world"));
    }
}
