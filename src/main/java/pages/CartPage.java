package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class CartPage extends HeaderPage {

    public static final String PRODUCT_NAME_XPATH = "//tr//*[contains(text(),'%s')]";
    public static final String PRODUCT_CSS = "#cart_summary .cart_item";
    public static final String DELETE_PRODUCT_BUTTON_XPATH = "//*[contains(text(),'%s')]/ancestor::tbody//*[@class = 'cart_quantity_delete']";

    /**
     * This method gets productName fro
     * @param productName
     * @return productName
     */
    public String getProductName(String productName){
        return $(By.xpath(String.format(PRODUCT_NAME_XPATH, productName))).getText();
    }

    /**
     * This method gets count of products in cart
     * @return int productsCount
     */
    public int getCountOfProducts(){
        return $$(PRODUCT_CSS).size();
    }

    /**
     * This method deletes a product from cart
     * @param productName
     * @return CartPage
     */
    public CartPage findProductByNameAndDelete(String productName){
        log.info("Click button 'Delete'.");
        $x(String.format(DELETE_PRODUCT_BUTTON_XPATH, productName)).click();
        $x(String.format(DELETE_PRODUCT_BUTTON_XPATH, productName)).shouldNotBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }
}
