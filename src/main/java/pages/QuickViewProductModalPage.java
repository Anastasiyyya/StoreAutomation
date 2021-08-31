package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class QuickViewProductModalPage extends ProductCategoryPage {

    public static final String ADD_TO_CART_BUTTON_CSS = "#add_to_cart > button > span";
    public static final String CLOSE_MODAL_BUTTON_CSS = "[title=Close]";

    /**
     * This method adds product to cart
     * @return ProductAddedModalPage
     */
    public ProductAddedModalPage addProductToCart() {
        log.info("Switch to frame");
        switchTo().frame(0);
        log.info("Click 'Add to cart' button");
        $(ADD_TO_CART_BUTTON_CSS).click();
        log.info("Switch to window");
        switchTo().window(0);
        return new ProductAddedModalPage();
    }
}
