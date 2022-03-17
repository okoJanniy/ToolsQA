package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DatePickerPage {

    private final String dataContainerLocator = "//*[@class='%s']" +
            "//*[text()='%s']";

    public void open() {
        Selenide.open("date-picker");
    }

    public void selectDate() {
        $("#datePickerMonthYearInput").click();
        Select selectYear = new Select($(".react-datepicker__year-select"));
        selectYear.selectByIndex(new Random().nextInt(selectYear.getOptions().size() - 1));
        Select selectMonth = new Select($(".react-datepicker__month-select"));
        selectMonth.selectByIndex(new Random().nextInt(selectMonth.getOptions().size() - 1));
        $x(String.format(dataContainerLocator, "react-datepicker__month",
                new Random().nextInt(27) + 1)).click();
    }

    public void selectDateAndTime() {
        $("#dateAndTimePickerInput").click();
        $(".react-datepicker__year-read-view").click();
        String[] yearDropdownData = $(".react-datepicker__year-dropdown")
                .getText().split("\n");
        $x(String.format(dataContainerLocator, "react-datepicker__year-dropdown",
                getRandomSingleData(yearDropdownData))).click();
        $(".react-datepicker__month-read-view").click();
        String[] monthDropdownData = $(".react-datepicker__month-dropdown")
                .getText().split("\n");
        $x(String.format(dataContainerLocator, "react-datepicker__month-dropdown",
                getRandomSingleData(monthDropdownData))).click();
        $x(String.format(dataContainerLocator, "react-datepicker__month",
                new Random().nextInt(27) + 1)).click();
        String[] timeData = $(".react-datepicker__time-list")
                .getText().split("\n");
        $x(String.format(dataContainerLocator, "react-datepicker__time-list",
                getRandomSingleData(timeData))).click();
        System.out.println();

    }

    private static String getRandomSingleData(String[] data) {
        List<String> filteredData = Arrays.stream(data).filter(x -> !x.equals("✓"))
                .collect(Collectors.toList());
        return filteredData.get(new Random().nextInt(filteredData.size() - 1));
    }
}
