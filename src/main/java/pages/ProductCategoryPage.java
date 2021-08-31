package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import page_elements.Dropdown;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProductCategoryPage extends BasePage {

    public ElementsCollection products = $$(".product_list .product-name");
    public SelenideElement searchMessage = $("#center_column > p");

    public static final String DROPDOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::form//select"; //Sort by //Show
    public static final String DROPDOWN_OPTION_XPATH = "//option[contains(text(),'%s')]";
    public static final String VIEW_CSS = "#%s";
    public static final String PRODUCT_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class='product-container']//img";
    public static final String PRODUCT_NAME_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@id='product_11_0_0_0']//p/a";
    public static final String PRODUCT_PRICE_XPATH = "//*[contains(text(),'%s')]/ancestor::*[@class = 'product-container']//*[@class ='content_price']/span";

    /**
     * This method chooses dropdown and click on dropdown option
     * @param dropdownName
     * @param option
     * @return ProductCategoryPage
     */
    @Step("Choose dropdown: {dropdownName} and option: {option}")
    public ProductCategoryPage chooseDropdownAndOption(String dropdownName, String option) {
        new Dropdown(dropdownName).selectDropdownOption(DROPDOWN_XPATH, DROPDOWN_OPTION_XPATH,option);
        return this;
    }

    /**
     * This method changes view of the products on the ProductCategoryPage (List/Grid)
     * @param view
     * @return ProductCategoryPage
     */
    @Step("Change view to {view}")
    public ProductCategoryPage changeViewTo(String view) {
        log.info(String.format("Change view to %s", view));
        $(String.format(VIEW_CSS, view)).click();
        return this;
    }

    /**
     * This method selects product by price
     * @param price
     * @return QuickViewProductModalPage
     */
    @Step("Select product with price: {price}")
    public QuickViewProductModalPage selectProductByPrice(String price){
        log.info(String.format("Select product with price: %s", price));
        SelenideElement product = $(By.xpath(String.format(PRODUCT_XPATH,price)));
        product.scrollIntoView(true).click();
        return new QuickViewProductModalPage();
    }

    /**
     * This method selects product by name
     * @param productName
     * @return QuickViewProductModalPage
     */
    @Step("Select product with name: {productName}")
    public QuickViewProductModalPage selectProductByName(String productName){
        log.info(String.format("Select product with name: %s", productName));
        SelenideElement product = $(By.xpath(String.format(PRODUCT_XPATH,productName)));
        product.scrollIntoView(true).click();
        return new QuickViewProductModalPage();
    }

    /**
     * This method gets productName by price
     * @param price
     * @return
     */
    public String getProductNameByPrice(String price){
        return $x(String.format(PRODUCT_NAME_XPATH, price)).getText();
    }

    /**
     * This method gets product price by name
     * @param productName
     * @return
     */
    public String getProductPriceByName(String productName){
        return $x(String.format(PRODUCT_PRICE_XPATH, productName)).getText();
    }

    public boolean isProductListNotEmpty() {
        ElementsCollection productList = products;
        log.info(String.format("Product list size is: %s", productList.size()));
        return !productList.isEmpty();
    }

    public String getSearchMessageText(){
        return searchMessage.getText();
    }

    public boolean isProductDisplayed(String productName) {
        return $(By.xpath(String.format(PRODUCT_XPATH,productName))).scrollIntoView(true).isDisplayed();
    }
}
