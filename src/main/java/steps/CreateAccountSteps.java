package steps;

import pageObjects.Account;
import pages.AuthorizationPage;
import pages.CreateAccountPage;

public class CreateAccountSteps {

    private final AuthorizationPage authorizationPage;
    private final CreateAccountPage createAccountPage;

    public CreateAccountSteps() {
        createAccountPage = new CreateAccountPage();
        authorizationPage = new AuthorizationPage();
    }

    public CreateAccountSteps createAccount(String email, Account account) {
        authorizationPage
                .openPage()
                .writeEmail(email);
        createAccountPage
                .createAccount(account);
        return this;
    }
}
