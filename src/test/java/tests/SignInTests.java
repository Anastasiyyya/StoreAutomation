package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static pages.MyAccountPage.ACCOUNT_NAME_TEXT_XPATH;
import static pages.MyAccountPage.CREATED_ACCOUNT_MESSAGE_XPATH;

public class SignInTests extends BaseTest {

    @Test(description = "Checking the possibility of entering the site")
    public void signInWithValidCredentialsTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(myAccountPage.getInfoMessageText(CREATED_ACCOUNT_MESSAGE_XPATH),"Welcome to your account. " +
                "Here you can manage all of your personal information and orders.");
        Assert.assertEquals(myAccountPage.getInfoMessageText(ACCOUNT_NAME_TEXT_XPATH),"Anastasiya S");
    }
}
