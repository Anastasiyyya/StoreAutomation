package page_elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    String label;

    public static final String BIRTHDAY_DROPDOWN_XPATH = "//*[contains(text(),'Date of Birth')]/ancestor::*[@class='form-group']//*[@id = '%s']"; //days /month /years

    public static final String DROPDOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'required')]";
    public static final String DROPDOWN_OPTION_XPATH = "//*[contains(@class,'form-control')]/descendant::*[contains(text(),'%s')]";

    public Dropdown(String label) {
        this.label = label;
    }

    /**
     * This method selects day,month and year dropdown options.
     * @param dropdownName
     * @param option
     */
    public void selectBirthdayDropdownOption(String dropdownName, String option) {
        $(By.xpath(String.format(BIRTHDAY_DROPDOWN_XPATH, dropdownName))).click();
        $(By.xpath(String.format(DROPDOWN_OPTION_XPATH, option))).click();
    }

    /**
     * This method selects dropdown option
     * @param option
     */
    public void selectDropdownOption(String option) {
        $(By.xpath(String.format(DROPDOWN_XPATH, label))).click();
        $(By.xpath(String.format(DROPDOWN_OPTION_XPATH, option))).click();
    }
}
