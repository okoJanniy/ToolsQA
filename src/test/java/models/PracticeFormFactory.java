package models;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class PracticeFormFactory {

    public static PracticeForm get() {
        Faker faker = new Faker();
        PracticeForm practiceForm = new PracticeForm();
        practiceForm.setFirstName(faker.name().firstName());
        practiceForm.setLastName(faker.name().lastName());
        practiceForm.setEmail(faker.internet().emailAddress());
        practiceForm.setGender(new Random().nextInt(2) + 1);
        practiceForm.setMobileNumber("1234567890");
        practiceForm.setDateOfBirth(getRandomDate());
        practiceForm.setSubjects("Maths");
        practiceForm.setHobbies(new Random().nextInt(2) + 1);
        practiceForm.setCurrentAddress(faker.address().fullAddress());
        practiceForm.setState("Haryana");
        practiceForm.setCity("Panipat");

        try (FileWriter writer = new FileWriter("picture.txt", false)) {
            writer.write("This is picture");
            practiceForm.setPicture(new File("picture.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return practiceForm;
    }

    private static String getRandomDate() {
        int randDay = new Random().nextInt(27) + 1;
        int randYear = new Random().nextInt(25) + 1990;
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return String.format("%s %s %s", randDay, month[new Random().nextInt(11)], randYear);
    }
}
