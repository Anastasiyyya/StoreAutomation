package pages;

import lombok.extern.log4j.Log4j2;
import page_elements.Button;

@Log4j2
public class ProductAddedModalPage extends ProductCategoryPage {

    public static final String MODAL_PAGE_BUTTONS = ".button-container [title='%s']";

    /**
     * This method clicks on 'ContinueShopping' button
     * @return ProductCategoryPage
     */
    public ProductCategoryPage clickContinueShoppingButton(){
        new Button().searchButtonAndClick(String.format(MODAL_PAGE_BUTTONS,"Продолжить покупки"));
        return new ProductCategoryPage();
    }

    /**
     * This method clicks on 'ProceedToCheckout' button
     * @return CartPage
     */
    public CartPage clickProceedToCheckoutButton(){
        log.info("Click 'Proceed to checkout' button");
        new Button().searchButtonAndClick(String.format(MODAL_PAGE_BUTTONS,"Оформить заказ"));
        return new CartPage();
    }
}
