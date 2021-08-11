package pages;

import page_elements.*;
import page_objects.Account;
import static com.codeborne.selenide.Selenide.$;

public class CreateAccountPage extends HeaderPage{

    public static final String REGISTRATION_BUTTON_CSS = "#submitAccount";
    public static final String MR_CSS = "#uniform-id_gender1";
    public static final String MRS_CSS = "#uniform-id_gender2";

    /**
     * This method fills necessary fields with data and creates an account
     * @param account
     * @return
     */
    public MyAccountPage createAccount(Account account) {
        new Button().waitForButtonVisible(REGISTRATION_BUTTON_CSS);
        new RadioButton().selectRadioButton(MRS_CSS);
        new Input("First name").enterTextToField(account.getFirstName());
        new Input("Last name").enterTextToField(account.getLastName());
        new Input("Password").enterTextToField(account.getPassword());
        new Dropdown("Date of Birth").selectBirthdayDropdownOption("days", account.getDayOfBirth());
        new Dropdown("Date of Birth").selectBirthdayDropdownOption("months", account.getMonthOfBirth());
        new Dropdown("Date of Birth").selectBirthdayDropdownOption("years", account.getYearOfBirth());
        new Checkbox("Sign up for our newsletter!").selectCheckbox();
        new Checkbox("Receive special offers from our partners!").selectCheckbox();
        $(REGISTRATION_BUTTON_CSS).click();
        return new MyAccountPage();
    }
}
