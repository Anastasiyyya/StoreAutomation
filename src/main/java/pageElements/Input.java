package pageElements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input {

    String label;
    public static final String INPUTS_XPATH = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'required')]//input";

    public Input(String label) {
        this.label = label;
    }

    /**
     * This method enters text to Input field.
     * @param text
     */
    public void enterTextToField(String text) {
        $(By.xpath(String.format(INPUTS_XPATH, label))).sendKeys(text);
    }
}
