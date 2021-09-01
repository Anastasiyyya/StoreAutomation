package steps;

import io.qameta.allure.Step;
import pages.AuthorizationPage;

public class AuthorizationSteps {

    private final AuthorizationPage authorizationPage;

    /**
     * This step helps to authorize on the site
     */
    public AuthorizationSteps() {
        authorizationPage = new AuthorizationPage();
    }

    /**
     * This step sign in to the site
     * @param email
     * @param password
     * @return AuthorizationPage
     */
    @Step("Sign in to account")
    public AuthorizationSteps signInToAccount(String email,String password) {
        authorizationPage
                .openPage()
                .signIn(email, password);
        return this;
    }
}
