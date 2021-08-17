package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class QuickViewProductModalPage extends ProductCategoryPage {

    public static final String ADD_TO_CART_BUTTON_CSS = "#add_to_cart > button > span";
    public static final String CLOSE_MODAL_BUTTON_CSS = "[title=Close]";

    /**
     * This method adds product to cart
     * @return ProductAddedModalPage
     */
    public ProductAddedModalPage addProductToCart() {
        switchTo().frame(0);
        $(ADD_TO_CART_BUTTON_CSS).click();
        switchTo().window(0);
        return new ProductAddedModalPage();
    }
}
