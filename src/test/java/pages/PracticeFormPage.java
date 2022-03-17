package pages;

import com.codeborne.selenide.*;
import models.PracticeForm;
import org.openqa.selenium.Keys;
import tests.BaseTest;
import wrappers.Input;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage extends BaseTest {

    public void open() {
        Selenide.open("automation-practice-form");
    }

    public void fillForm(PracticeForm userData) {
        new PracticeFormPage().fillAllInputs(userData);
        new PracticeFormPage().chooseGenderRadioButton(userData.getGender());
        new PracticeFormPage().chooseHobbiesCheckboxes(userData.getHobbies());
        new PracticeFormPage().uploadFile(userData.getPicture());
        new PracticeFormPage().selectStateAndCity(userData.getState(), userData.getCity());
    }

    private void fillAllInputs(PracticeForm userData) {
        new Input(userData.getFirstName()).addTextByCssId("firstName");
        new Input(userData.getLastName()).addTextByCssId("lastName");
        new Input(userData.getEmail()).addTextByCssId("userEmail");
        new Input(userData.getMobileNumber()).addTextByCssId("userNumber");
        $("#dateOfBirthInput").sendKeys(userData.getDateOfBirth(), Keys.ENTER);
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys(userData.getSubjects(), Keys.ENTER);
        new Input(userData.getCurrentAddress()).addTextByCssId("currentAddress");
    }

    private void chooseGenderRadioButton(int genderId) {
        $(String.format("#gender-radio-%s", genderId)).click();
    }

    private void chooseHobbiesCheckboxes(int hobbiesId) {
        $(String.format("#hobbies-checkbox-%s", hobbiesId)).click();
    }

    private void uploadFile(File userFile) {
        $("#uploadPicture").uploadFile(userFile);
        userFile.deleteOnExit();
    }

    private void selectStateAndCity(String state, String city) {
        $("body").sendKeys(Keys.END);
        $("#react-select-3-input").sendKeys(state, Keys.ENTER);
        $("#react-select-4-input").sendKeys(city, Keys.ENTER);
    }

    public boolean isDataInFormCorrect(PracticeForm userData) {
        boolean allDataCorrect = true;
        if ($("#firstName").getText().equals(userData.getFirstName())) {
            allDataCorrect = false;
        } else if ($("#lastName").getText().equals(userData.getLastName())) {
            allDataCorrect = false;
        } else if ($("#userEmail").getText().equals(userData.getEmail())) {
            allDataCorrect = false;
        } else if ($("#userNumber").getText().equals(userData.getMobileNumber())) {
            allDataCorrect = false;
        } else if ($("#dateOfBirthInput").getText().equals(userData.getDateOfBirth())) {
            allDataCorrect = false;
        } else if ($("#subjectsContainer").getText().equals(userData.getSubjects())) {
            allDataCorrect = false;
        } else if ($("#currentAddress").getText().equals(userData.getCurrentAddress())) {
            allDataCorrect = false;
        } else if (!$(String.format("#gender-radio-%s", userData.getGender())).isSelected()) {
            allDataCorrect = false;
        } else if (!$(String.format("#hobbies-checkbox-%s", userData.getHobbies())).isSelected()) {
            allDataCorrect = false;
        } else if ($("#react-select-3-input").getText().equals(userData.getState())) {
            allDataCorrect = false;
        } else if ($("#react-select-4-input").getText().equals(userData.getCity())) {
            allDataCorrect = false;
        }
        return allDataCorrect;
    }
}
