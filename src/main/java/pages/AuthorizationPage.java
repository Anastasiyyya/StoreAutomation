package pages;

import page_elements.Button;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends HeaderPage{

    public static final String CREATE_AN_ACCOUNT_BUTTON_CSS = "#SubmitCreate";
    public static final String SIGN_IN_BUTTON_CSS = "#SubmitLogin";
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
        new Button().waitForButtonVisible(CREATE_AN_ACCOUNT_BUTTON_CSS);
        $(CREATE_AN_ACCOUNT_EMAIL_INPUT_CSS).sendKeys(email);
        $(CREATE_AN_ACCOUNT_BUTTON_CSS).click();
        return new CreateAccountPage();
    }

    /**
     *This method writes email to email and password to input fields, clicks to 'sign in' button and goes to the Account Page
     * @param email
     * @param password
     * @return
     */
    public MyAccountPage signIn(String email, String password) {
        new Button().waitForButtonVisible(SIGN_IN_BUTTON_CSS);
        $(SIGN_IN_EMAIL_INPUT_CSS).sendKeys(email);
        $(SIGN_IN_PASSWORD_INPUT_CSS).sendKeys(password);
        $(SIGN_IN_BUTTON_CSS).click();
        return new MyAccountPage();
    }
}
