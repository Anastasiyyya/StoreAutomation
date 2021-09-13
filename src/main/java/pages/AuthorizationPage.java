package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import page_elements.Button;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AuthorizationPage extends HeaderPage{

    public static final String CREATE_AN_ACCOUNT_EMAIL_INPUT_CSS = "#email_create";
    public static final String SIGN_IN_EMAIL_INPUT_CSS = "#email";
    public static final String SIGN_IN_PASSWORD_INPUT_CSS = "#passwd";

    /**
     * This method opens page by URL
     * @return
     */
    @Step("Opening authorization page")
    public AuthorizationPage openPage() {
        super.openPage(STORE_AUTOMATION_AUTHORIZATION_PAGE_URL);
        return this;
    }

    /**
     * This method writes email to email input field, clicks to 'create an account button and goes to the Create Account Page
     * @param email
     * @return
     */
    @Step("Fill in {email} in Email field")
    public CreateAccountPage writeEmail(String email) {
        new Button().waitForButtonVisibleByLabel("Create an account");
        log.info(String.format("Fill in email: '%s' in sign in email field.", email));
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
    @Step("Sign in with email:{email} and password:{password}")
    public MyAccountPage signIn(String email, String password) {
        new Button().waitForButtonVisibleByLabel("Sign in");
        log.info(String.format("Fill in email: '%s' in sign in email field.", email));
        $(SIGN_IN_EMAIL_INPUT_CSS).sendKeys(email);
        log.info(String.format("Fill in password: '%s' in password field.", password));
        $(SIGN_IN_PASSWORD_INPUT_CSS).sendKeys(password);
        log.info("Click button 'Sign in'.");
        new Button("Sign in").searchButtonByLabelAndClick();
        return new MyAccountPage();
    }
}
