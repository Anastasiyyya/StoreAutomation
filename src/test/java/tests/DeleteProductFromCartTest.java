package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class DeleteProductFromCartTest extends BaseTest {

    @Test(description = "checking that product has been deleted from cart")
    public void deleteProductFromCartTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage.moveToMenuButton(WOMEN)
                .changeCurrencyTo(DOLLAR)
                .moveAndClickOnSubMenuButton(SUMMER_DRESSES)
                .chooseDropdownAndOption(SHOW_DROPDOWN,SHOW_DROPDOWN_12)
                .chooseDropdownAndOption(SORT_BY_DROPDOWN, PRICE_LOWEST_FIRST)
                .changeViewTo(VIEW_AS_LIST)
                .selectProductByPrice(SUMMER_DRESS_PRODUCT_PRICE)
                .addProductToCart()
                .clickContinueShoppingButton()
                .selectProductByName(ROYAL_BLUE_DRESS)
                .addProductToCart()
                .clickProceedToCheckoutButton()
                .findProductByNameAndDelete(PRINTED_MAXI_DRESS);
        Assert.assertEquals(cartPage.getCountOfProducts(),1);
    }
}
