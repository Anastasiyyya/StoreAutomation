package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_elements.Button;
import utils.PropertyReader;

public class SignOutTest extends BaseTest {

    @Test(description = "Checking the possibility of sign out from account")
    public void signInWithValidCredentialsTest() {
        authorizationSteps.signInToAccount(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        headerPage.clickOnLogOutButton();
        Assert.assertTrue(new Button("Sign in").isButtonDisplayed());
    }
}
