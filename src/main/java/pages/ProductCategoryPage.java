package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_elements.Dropdown;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

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
    public ProductCategoryPage chooseDropdownAndOption(String dropdownName, String option) {
        new Dropdown(dropdownName).selectDropdownOption(DROPDOWN_XPATH, DROPDOWN_OPTION_XPATH,option);
        return this;
    }

    /**
     * This method changes view of the products on the ProductCategoryPage (List/Grid)
     * @param view
     * @return ProductCategoryPage
     */
    public ProductCategoryPage changeViewTo(String view) {
        $(String.format(VIEW_CSS, view)).click();
        return this;
    }

    /**
     * This method selects product by price
     * @param price
     * @return QuickViewProductModalPage
     */
    public QuickViewProductModalPage selectProductByPrice(String price){
        SelenideElement product = $(By.xpath(String.format(PRODUCT_XPATH,price)));
        product.scrollIntoView(true).click();
        return new QuickViewProductModalPage();
    }

    /**
     * This method selects product by name
     * @param productName
     * @return QuickViewProductModalPage
     */
    public QuickViewProductModalPage selectProductByName(String productName){
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
        return !productList.isEmpty();
    }

    public String getSearchMessageText(){
        return searchMessage.getText();
    }
}
