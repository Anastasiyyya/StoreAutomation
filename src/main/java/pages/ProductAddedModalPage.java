package pages;

import page_elements.Button;

public class ProductAddedModalPage extends ProductCategoryPage {

    public static final String MODAL_PAGE_BUTTONS = ".button-container [title='%s']"; //Продолжить покупки //Оформить заказ

    /**
     * This method clicks on 'ContinueShopping' button
     * @return ProductCategoryPage
     */
    public ProductCategoryPage clickContinueShoppingButton(){
        new Button().clickButton(String.format(MODAL_PAGE_BUTTONS,"Продолжить покупки"));
        return new ProductCategoryPage();
    }

    /**
     * This method clicks on 'ProceedToCheckout' button
     * @return CartPage
     */
    public CartPage clickProceedToCheckoutButton(){
        new Button().clickButton(String.format(MODAL_PAGE_BUTTONS,"Оформить заказ"));
        return new CartPage();
    }
}
