package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class SliderPage {

    public void open() {
        Selenide.open("slider");
    }

    public void dragSliderTo85() {
        Selenide.actions()
                .dragAndDropBy($(".range-slider__wrap"), 155, 242)
                .build()
                .perform();
        System.out.println();
    }

    public String getSliderValue() {
        return $(".range-slider").getAttribute("value");
    }
}
