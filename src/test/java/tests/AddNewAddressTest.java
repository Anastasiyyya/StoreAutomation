package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Address;
import test_data.Utils;
import utils.PropertyReader;

public class AddNewAddressTest extends BaseTest {

    @Test(description = "Check that the address has been added")
    public void addNewAddressTest() {
        Address address = new Address(FIRST_NAME, LAST_NAME, COMPANY, ADDRESS, ZIP_CODE, CITY, COUNTRY, HOME_PHONE, MOBILE_PHONE, Utils.generateRandomString(5));
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        addNewAddressSteps
                .addNewAddress(address);
        Assert.assertFalse(myAddressesPage.IsAddressesListEmpty());
    }

    @Test(description = "Check that the address list is empty")
    public void deleteAllAddressesTest() {
        Address address = new Address(FIRST_NAME, LAST_NAME, COMPANY, ADDRESS, ZIP_CODE, CITY, COUNTRY, HOME_PHONE, MOBILE_PHONE, Utils.generateRandomString(5));
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        addNewAddressSteps
                .addNewAddress(address);
        myAddressesPage.deleteAllAddressesIfExist();
        Assert.assertTrue(myAddressesPage.IsAddressesListEmpty());
        Assert.assertEquals(myAddressesPage.getWarningText(), "No addresses are available. Add a new address");
    }
}
