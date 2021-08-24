package pages;

import page_elements.Button;

public class ProductAddedModalPage extends ProductCategoryPage {

    public static final String MODAL_PAGE_BUTTONS = ".button-container [title='%s']";

    /**
     * This method clicks on 'ContinueShopping' button
     * @return ProductCategoryPage
     */
    public ProductCategoryPage clickContinueShoppingButton(){
        new Button().searchButtonByCssAndClick(String.format(MODAL_PAGE_BUTTONS,"Продолжить покупки"));
        return new ProductCategoryPage();
    }

    /**
     * This method clicks on 'ProceedToCheckout' button
     * @return CartPage
     */
    public CartPage clickProceedToCheckoutButtonFromModal(){
        new Button().searchButtonByCssAndClick(String.format(MODAL_PAGE_BUTTONS,"Оформить заказ"));
        return new CartPage();
    }
}
