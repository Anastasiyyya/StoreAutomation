package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import page_elements.*;
import page_objects.Address;
import static com.codeborne.selenide.Selenide.*;

public class MyAddressesPage extends MyAccountPage {

    private final ElementsCollection addressesList = $$(".addresses .address");
    private final ElementsCollection addressesList_Delete = $$("[title='Delete']");

    /**
     * This method adds a new address
     * @param address
     * @return MyAddressesPage
     */
    public MyAddressesPage addNewAddress(Address address){
        new Button().waitForButtonVisibleByLabel("Add a new address");
        new Button("Add a new address").click();
        new Input("First name").enterTextToField(address.getFirstName());
        new Input("Last name").enterTextToField(address.getLastName());
        new Input("Company").enterTextToField(address.getCompany());
        new Input("Address ").enterTextToField(address.getAddress());
        new Input("Zip/Postal Code ").enterTextToField(address.getZipCode());
        new Input("City ").enterTextToField(address.getCity());
        new Dropdown("Country ").select("США");
        new Input("Home phone ").enterTextToField(address.getHomePhone());
        new Input("Mobile phone ").enterTextToField(address.getMobilePhone());
        new Dropdown("State ").select("New York");
        new Input("Please assign an address title for future reference. ").enterTextToField(address.getTitle());
        new Button("Save").click();
        return this;
    }

    /**
     * This method deletes all addresses
     * @return MyAddressesPage
     */
    public MyAddressesPage deleteAllAddressesIfExist() {
        addressesList_Delete.stream().iterator().forEachRemaining(SelenideElement::click);
        switchTo().alert().accept();
        return this;
    }

    /**
     * This method check that the addresses list iss empty.
     * @return boolean
     */
    public boolean addressesListIsEmpty(){
        return addressesList.isEmpty();
    }

    /**
     * This method gets warning message when addresses list is empty
     * @return message
     */
    public String getWarningAfterDelete() {
        return $(".alert").getText();
    }
}
