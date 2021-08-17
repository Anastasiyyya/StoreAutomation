package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Account;
import utils.PropertyReader;

public class ChangePersonalInfoTest extends BaseTest {

    @Test(description = "checking that ")
    public void searchWithEmptyDataTest() {
        Account account = new Account(FIRST_NAME, LAST_NAME, PASSWORD);

        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage
                .clickOnAccountButton()
                .clickOnPersonalInfoButton()
                .replaceDataAndSave(account);
        //Assert.assertEquals(personalInfoPage.getChangedMessageText(), "Your personal information has been successfully updated.");
    }
}
