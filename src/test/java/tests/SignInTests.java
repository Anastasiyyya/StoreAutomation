package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static pages.MyAccountPage.ACCOUNT_NAME_TEXT_CSS;
import static pages.MyAccountPage.CREATED_ACCOUNT_MESSAGE_CSS;

public class SignInTests extends BaseTest {

    @Test(description = "Checking the possibility of entering the site")
    public void signInWithValidCredentialsTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(myAccountPage.getText(CREATED_ACCOUNT_MESSAGE_CSS),"Welcome to your account. " +
                "Here you can manage all of your personal information and orders.");
        Assert.assertEquals(myAccountPage.getText(ACCOUNT_NAME_TEXT_CSS),"Anastasiya S");
    }
}
