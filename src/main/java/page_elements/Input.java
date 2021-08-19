package page_elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Input {

    String label;
    public static final String INPUTS_XPATH = "//label[contains(text(),'%s')]/..//input";

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

    public void replaceFieldTextTo(String text) {
        $(By.xpath(String.format(INPUTS_XPATH, label))).clear();
        $(By.xpath(String.format(INPUTS_XPATH, label))).sendKeys(text);
    }
}
