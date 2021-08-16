package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class AddProductsToCartTests extends BaseTest {

    @Test(description = "checking that product has been added to cart")
    public void addProductToCartTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage.moveToMenuButton(WOMEN)
                .changeCurrencyTo(DOLLAR)
                .moveAndClickOnSubMenuButton(SUMMER_DRESSES)
                .chooseDropdownAndOption(SHOW_DROPDOWN,SHOW_DROPDOWN_24)
                .chooseDropdownAndOption(SORT_BY_DROPDOWN, PRICE_LOWEST_FIRST)
                .changeViewTo(VIEW_AS_LIST)
                .selectProductByPrice(SUMMER_DRESS_PRODUCT_PRICE)
                .addProductToCart()
                .clickProceedToCheckoutButton();
        Assert.assertEquals(productCategoryPage.getProductNameByPrice(SUMMER_DRESS_PRODUCT_PRICE), "Printed Maxi Dress");
    }

    @Test(description = "checking that two products has been added to cart")
    public void addMultiplyProductToCartTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage.moveToMenuButton(WOMEN)
                .changeCurrencyTo(DOLLAR)
                .moveAndClickOnSubMenuButton(SUMMER_DRESSES)
                .chooseDropdownAndOption(SHOW_DROPDOWN,SHOW_DROPDOWN_24)
                .chooseDropdownAndOption(SORT_BY_DROPDOWN, PRICE_LOWEST_FIRST)
                .changeViewTo(VIEW_AS_LIST)
                .selectProductByPrice(SUMMER_DRESS_PRODUCT_PRICE)
                .addProductToCart()
                .clickContinueShoppingButton()
                .selectProductByName(ROYAL_BLUE_DRESS)
                .addProductToCart()
                .clickProceedToCheckoutButton();
        Assert.assertEquals(cartPage.getCountOfProducts(),2);
    }
}
