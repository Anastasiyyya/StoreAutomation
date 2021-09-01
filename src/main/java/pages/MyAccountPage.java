package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
@Log4j2
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
    @Step("Click 'My Addresses' button ")
    public MyAddressesPage clickMyAddressesButton() {
        log.info("Click 'My addresses' button");
        myAddressesButton.click();
        return new MyAddressesPage();
    }
}
