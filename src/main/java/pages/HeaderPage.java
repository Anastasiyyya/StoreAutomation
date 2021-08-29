package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import page_elements.Button;
import page_elements.Dropdown;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class HeaderPage extends BasePage{

    public SelenideElement searchInputField = $("#search_query_top");
    public SelenideElement searchButton = $("#searchbox > button");
    public SelenideElement accountButton = $(".account");
    public SelenideElement logOutButton = $(".logout");

    public static final String CART_DROPDOWN_CSS = "#header .shopping_cart > a";
    public static final String BLOCK_TOP_MENU_CSS = "#block_top_menu a[title=%s]";
    public static final String BLOCK_SUB_MENU_CSS = ".submenu-container ul [title='%s']";

    public static final String DROPDOWN_CURRENCY_XPATH = "//*[contains(text(),'%s')]";
    public static final String DROPDOWN_CURRENCY_OPTION_CSS = "//*[@title='%s']";

    /**
     * This method moves to menu button.
     * @param buttonName
     * @return HeaderPage
     */
    public HeaderPage moveToMenuButton(String buttonName) {
        new Button().waitForButtonVisible((String.format(BLOCK_TOP_MENU_CSS,buttonName)));
        log.info("Move to menu button");
        actions().moveToElement($(String.format(BLOCK_TOP_MENU_CSS, buttonName))).perform();
        return this;
    }

    /**
     * This method moves and clicks on subMenu button.
     * @param buttonName
     * @return
     */
    public ProductCategoryPage moveAndClickOnSubMenuButton(String buttonName) {
        log.info("Move to sub menu button");
        actions().moveToElement($(String.format(BLOCK_SUB_MENU_CSS, buttonName))).click().perform();
        return new ProductCategoryPage();
    }

    /**
     * This method changes currency on the site to another
     * @param currency
     * @return HeaderPage
     */
    public HeaderPage changeCurrencyTo(String currency) {
        log.info(String.format("Change currency to: %s", currency));
        new Dropdown("Валюта :").selectDropdownOption(DROPDOWN_CURRENCY_XPATH,DROPDOWN_CURRENCY_OPTION_CSS, currency);
        return this;
    }

    /**
     * This method searches product by name
     * @param productName
     * @return ProductCategoryPage
     */
    public ProductCategoryPage searchProduct(String productName) {
        log.info(String.format("Fill in product name: '%s' ", productName));
        searchInputField.sendKeys(productName);
        log.info("Click 'Search' button");
        searchButton.click();
        return new ProductCategoryPage();
    }

    /**
     * This method clicks on account button
     * @return MyAccountPage
     */
    public MyAccountPage clickOnAccountButton(){
        log.info("Click 'Account' button");
        accountButton.click();
        return new MyAccountPage();
    }

    /**
     * This method clicks on logOut button
     * @return BasePage
     */
    public BasePage clickOnLogOutButton(){
        log.info("Click 'Log out' button");
        logOutButton.click();
        return new BasePage();
    }
}
