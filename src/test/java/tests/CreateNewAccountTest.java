package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Account;
import test_data.Utils;

import static pages.MyAccountPage.CREATED_ACCOUNT_MESSAGE_XPATH;

public class CreateNewAccountTest extends BaseTest {

    @Test(description = "Check that the account has been created")
    public void createAccountTest() {
        Account account = new Account(FIRST_NAME, LAST_NAME, PASSWORD, BIRTH_DAY, BIRTH_MONTH, BIRTH_YEAR,
                COMPANY, ADDRESS, CITY, STATE, ZIP_CODE, COUNTRY, MOBILE_PHONE);
        createAccountSteps
                .createAccount(Utils.generateRandomString(5) + EMAIL, account);
        Assert.assertEquals(myAccountPage.getInfoMessageText(CREATED_ACCOUNT_MESSAGE_XPATH),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }
}
