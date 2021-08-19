package steps;

import page_constants.IConstants;
import page_objects.Address;
import pages.BasePage;
import pages.HeaderPage;
import pages.MyAddressesPage;

public class AddNewAddressSteps {

    private final MyAddressesPage myAddressesPage;
    private final BasePage basePage;
    private final HeaderPage headerPage;

    public AddNewAddressSteps() {
        myAddressesPage = new MyAddressesPage();
        basePage = new BasePage();
        headerPage = new HeaderPage();
    }

    public AddNewAddressSteps addNewAddress(Address address) {
        basePage
                .openPage(IConstants.STORE_AUTOMATION_BASE_URL);
        headerPage
                .clickOnAccountButton()
                .clickMyAddressesButton()
                .addNewAddress(address);
        return this;
    }
}
