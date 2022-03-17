package models;

import java.util.Random;

public class CheckBoxTitleFactory {

    public static String get() {
        Random random = new Random();
        String[] titleMas = {"Home", "Desktop", "Notes", "Commands", "Documents", "WorkSpace",
                "React", "Angular", "Veu", "Office", "Public", "Private", "Classified",
                "General", "Downloads", "Word File.doc", "Excel File.doc"};
        return titleMas[random.nextInt(titleMas.length - 1)];
    }
}
