package tests;

import org.testng.annotations.Test;
import pages.DatePickerPage;

public class DatePickerTest extends BaseTest {

    @Test
    public void selectDateAndTimeTest() {
        DatePickerPage datePickerPage = new DatePickerPage();
        datePickerPage.open();
        datePickerPage.selectDateAndTime();
    }

    @Test
    public void selectDateTest() {
        DatePickerPage datePickerPage = new DatePickerPage();
        datePickerPage.open();
        datePickerPage.selectDate();
    }
}
