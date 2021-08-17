package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class SignInTests extends BaseTest {

    @Test(description = "Checking the possibility of entering the site")
    public void signInWithValidCredentialsTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                        System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(myAccountPage.getMessageText(),"Welcome to your account. " +
                "Here you can manage all of your personal information and orders.");
        Assert.assertEquals(myAccountPage.getAccountName(),"Anastasiya S");
    }
}
