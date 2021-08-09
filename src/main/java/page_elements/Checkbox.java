package page_elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Checkbox {

    String label;

    public static final String CHECKBOX_XPATH = "//*[contains(text(),'%s')]//ancestor::*[@class = 'checkbox']//div";

    public Checkbox(String label) {
        this.label = label;
    }

    /**
     * This method selects checkbox.
     */
    public void selectCheckbox() {
        $(By.xpath(String.format(CHECKBOX_XPATH, label))).click();
    }
}
