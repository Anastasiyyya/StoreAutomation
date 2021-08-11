package page_elements;

import static com.codeborne.selenide.Selenide.$;

public class RadioButton {

    /**
     * This method select radiobutton.
     * @param gender
     */
    public void selectRadioButton(String gender) {
        $(gender).click();
    }
}
