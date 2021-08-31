package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import page_elements.*;
import page_objects.Address;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class MyAddressesPage extends MyAccountPage {

    private final ElementsCollection addressesList = $$(".addresses .address");
    private final ElementsCollection deleteAddressesList = $$("[title='Delete']");

    /**
     * This method adds a new address
     * @param address
     * @return MyAddressesPage
     */
    public MyAddressesPage addNewAddress(Address address){
        new Button().waitForButtonVisibleByLabel("Add a new address");
        log.info("Click 'Add a new address' button");
        new Button("Add a new address").searchButtonByLabelAndClick();
        new Input("First name").enterTextToField(address.getFirstName());
        new Input("Last name").enterTextToField(address.getLastName());
        new Input("Company").enterTextToField(address.getCompany());
        new Input("Address ").enterTextToField(address.getAddress());
        new Input("Zip/Postal Code ").enterTextToField(address.getZipCode());
        new Input("City ").enterTextToField(address.getCity());
        new Dropdown("Country ").selectOption("США");
        new Input("Home phone ").enterTextToField(address.getHomePhone());
        new Input("Mobile phone ").enterTextToField(address.getMobilePhone());
        new Dropdown("State ").selectOption("New York");
        new Input("Please assign an address title for future reference. ").enterTextToField(address.getTitle());
        log.info("Click 'Save' button");
        new Button("Save").searchButtonByLabelAndClick();
        return this;
    }

    /**
     * This method deletes all addresses
     * @return MyAddressesPage
     */
    public MyAddressesPage deleteAllAddressesIfExist() {
        deleteAddressesList.stream().iterator().forEachRemaining(SelenideElement::click);
        switchTo().alert().accept();
        return this;
    }

    /**
     * This method check that the addresses list iss empty.
     * @return boolean
     */
    public boolean IsAddressesListEmpty(){
        return addressesList.isEmpty();
    }

    /**
     * This method gets warning message when addresses list is empty
     * @return message
     */
    public String getWarningText() {
        return $(".alert").getText();
    }
}
