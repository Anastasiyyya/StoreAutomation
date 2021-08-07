package steps;

import pages.AuthorizationPage;

public class AuthorizationSteps {

    private final AuthorizationPage authorizationPage;

    public AuthorizationSteps() {
        authorizationPage = new AuthorizationPage();
    }

    public AuthorizationSteps signInToAccount(String email,String password) {
        authorizationPage
                .openPage()
                .signIn(email, password);
        return this;
    }
}
