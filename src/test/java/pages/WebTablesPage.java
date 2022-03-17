package pages;

import com.codeborne.selenide.Selenide;
import models.WebTableUser;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage {

    public void open() {
        Selenide.open("webtables");
    }

    public void addNewUser(WebTableUser userData) {
        $("#addNewRecordButton").click();
        new WebTablesPage().fillForm(userData);
        $("#submit").click();
    }

    public void editUser(WebTableUser userData, WebTableUser newUserData) {
        $x(String.format("//*[contains(text(), '%s')]/ancestor::" +
                "div[contains(@class, 'group')]//*[@title='Edit']", userData.getEmail())).click();
        new WebTablesPage().fillForm(newUserData);
        $("#submit").click();
    }

    private void fillForm(WebTableUser userData) {
        new Input(userData.getFirstName()).addTextByCssId("firstName");
        new Input(userData.getLastName()).addTextByCssId("lastName");
        new Input(userData.getEmail()).addTextByCssId("userEmail");
        new Input(userData.getAge()).addTextByCssId("age");
        new Input(userData.getSalary()).addTextByCssId("salary");
        new Input(userData.getDepartment()).addTextByCssId("department");
    }

    public void deleteUser(WebTableUser userData) {
        $x(String.format("//*[contains(text(), '%s')]/ancestor::" +
                "div[contains(@class, 'group')]//*[@title='Delete']", userData.getEmail())).click();
    }

    public void findUser(WebTableUser userData) {
        new Input(userData.getEmail()).addTextByCssId("searchBox");
    }

    public boolean isUserDataCorrect(WebTableUser userData) {
        String[] savedUserData = $x(String.format("//*[contains(text(), '%s')]/ancestor::" +
                "div[contains(@class,'group')]", userData.getEmail())).getText().split("\n");
        int numberOfCorrectData = 0;
        for (String data : savedUserData) {
            if (data.equals(userData.getFirstName())) {
                numberOfCorrectData += 1;
            } else if (data.equals(userData.getLastName())) {
                numberOfCorrectData += 1;
            } else if (data.equals(userData.getEmail())) {
                numberOfCorrectData += 1;
            } else if (data.equals(userData.getAge())) {
                numberOfCorrectData += 1;
            } else if (data.equals(userData.getSalary())) {
                numberOfCorrectData += 1;
            } else if (data.equals(userData.getDepartment())) {
                numberOfCorrectData += 1;
            }
        }
        return numberOfCorrectData == 6;
    }

    public boolean isUserExists(WebTableUser userData) {
        return $$x(String.format("//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'group')]",
                userData.getEmail())).size() == 1;
    }

    public int numOfUsers() {
        return $$x("//*[contains(@id, 'edit-record')]/ancestor::div[contains(@class, 'group')]")
                .size();
    }
}
