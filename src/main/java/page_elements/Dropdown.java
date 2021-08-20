package page_elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    String label;

    public static final String BIRTHDAY_YEAR_DROPDOWN_CSS = "#cuselFrame-years";
    public static final String BIRTHDAY_DAY_MONTH_DROPDOWN_CSS = "[name='%s']"; //days //months

    public static final String DROPDOWN_YEAR_OPTION_CSS = "#cusel-scroll-years [val='%s']";
    public static final String DROPDOWN_OPTION_CSS = "#%s [value='%s']"; //days //months

    public Dropdown(String label) {
        this.label = label;
    }

    /**
     * This method selects day,month and year dropdown options.
     * @param dropdownName
     * @param option
     */
    public void selectBirthdayDropdownOption(String dropdownName, String option) {

        if(dropdownName.equals("years")){
            $(BIRTHDAY_YEAR_DROPDOWN_CSS).click();
            $(String.format(DROPDOWN_YEAR_OPTION_CSS, option)).scrollIntoView(true).click();
        } else {
            $(String.format(BIRTHDAY_DAY_MONTH_DROPDOWN_CSS, dropdownName)).click();
            $(String.format(DROPDOWN_OPTION_CSS,dropdownName, option)).click();
        }
    }

    /**
     * This method selects dropdown option
     * @param option,dropdownName
     */
    public void selectDropdownOption(String dropdownXpath,String dropdownOptionXpath, String option) {
        $(By.xpath(String.format(dropdownXpath, label))).click();
        $(By.xpath(String.format(dropdownOptionXpath, option))).click();
    }
}
