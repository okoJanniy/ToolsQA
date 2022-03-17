package models;

import com.github.javafaker.Faker;

public class WebTableUserFactory {

    public static WebTableUser get() {
        Faker faker = new Faker();
        WebTableUser webTableUser = new WebTableUser();
        webTableUser.setFirstName(faker.name().firstName());
        webTableUser.setLastName(faker.name().lastName());
        webTableUser.setEmail(faker.internet().emailAddress());
        webTableUser.setAge(String.valueOf(faker.number().numberBetween(14, 85)));
        webTableUser.setSalary(String.valueOf(faker.number().numberBetween(100, 50000)));
        webTableUser.setDepartment(faker.address().secondaryAddress());
        return webTableUser;
    }
}
