package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
public class MyAccountPage extends HeaderPage {

    protected SelenideElement myAddressesButton = $x("//*[contains(text(),'My addresses')]");
    public static final String CREATED_ACCOUNT_MESSAGE_CSS = "#center_column p";
    public static final String ACCOUNT_NAME_TEXT_CSS = ".header_user_info span";

    /**
     * This method gets created account message
     * @return message
     */
    public String getMessageText() {
        return $(CREATED_ACCOUNT_MESSAGE_CSS).getText();
    }

    /**
     * This method gets account name from header
     * @return name
     */
    public String getAccountName() {
        return $(ACCOUNT_NAME_TEXT_CSS).getText();
    }

    /**
     * This method clicks on 'My addresses button'
     * @return MyAddressesPage
     */
    public MyAddressesPage clickMyAddressesButton() {
        myAddressesButton.click();
        return new MyAddressesPage();
    }
}
