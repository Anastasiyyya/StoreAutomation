package steps;

import io.qameta.allure.Step;
import page_objects.Account;
import pages.AuthorizationPage;
import pages.CreateAccountPage;

public class CreateAccountSteps {

    private final AuthorizationPage authorizationPage;
    private final CreateAccountPage createAccountPage;

    public CreateAccountSteps() {
        createAccountPage = new CreateAccountPage();
        authorizationPage = new AuthorizationPage();
    }

    /**
     * This step creates an account
     * @param email
     * @param account
     * @return CreateAccountSteps
     */
    @Step("Creating an account")
    public CreateAccountSteps createAccount(String email, Account account) {
        authorizationPage
                .openPage()
                .writeEmail(email);
        createAccountPage
                .createAccount(account);
        return this;
    }
}
