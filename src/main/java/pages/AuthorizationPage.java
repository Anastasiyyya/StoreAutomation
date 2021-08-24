package pages;

import page_elements.Button;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends HeaderPage{

    public static final String CREATE_AN_ACCOUNT_EMAIL_INPUT_CSS = "#email_create";
    public static final String SIGN_IN_EMAIL_INPUT_CSS = "#email";
    public static final String SIGN_IN_PASSWORD_INPUT_CSS = "#passwd";

    /**
     * This method opens page by URL
     * @return
     */
    public AuthorizationPage openPage() {
        super.openPage(STORE_AUTOMATION_AUTHORIZATION_PAGE_URL);
        return this;
    }

    /**
     * This method writes email to email input field, clicks to 'create an account button and goes to the Create Account Page
     * @param email
     * @return
     */
    public CreateAccountPage writeEmail(String email) {
        new Button().waitForButtonVisibleByLabel("Create an account");
        $(CREATE_AN_ACCOUNT_EMAIL_INPUT_CSS).sendKeys(email);
        new Button("Create an account").searchButtonByLabelAndClick();
        return new CreateAccountPage();
    }

    /**
     *This method writes email to email and password to input fields, clicks to 'sign in' button and goes to the Account Page
     * @param email
     * @param password
     * @return
     */
    public MyAccountPage signIn(String email, String password) {
        new Button().waitForButtonVisibleByLabel("Sign in");
        $(SIGN_IN_EMAIL_INPUT_CSS).sendKeys(email);
        $(SIGN_IN_PASSWORD_INPUT_CSS).sendKeys(password);
        new Button("Sign in").searchButtonByLabelAndClick();
        return new MyAccountPage();
    }
}
