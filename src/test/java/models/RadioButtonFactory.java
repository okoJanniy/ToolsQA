package models;

import java.util.Random;

public class RadioButtonFactory {

    public static String get() {
        Random random = new Random();
        String[] buttonNames = {"Yes", "Impressive", "No"};
        return buttonNames[random.nextInt(buttonNames.length - 1)];
    }
}
