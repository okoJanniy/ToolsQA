package models;

import com.github.javafaker.Faker;

public class TextBoxFactory {

    public static TextBox get() {
        Faker faker = new Faker();
        TextBox textBox = new TextBox();
        textBox.setName(faker.name().fullName());
        textBox.setMail(faker.internet().emailAddress());
        textBox.setCurAddress(faker.address().fullAddress());
        textBox.setPermAddress(faker.address().secondaryAddress());
        return textBox;
    }
}
