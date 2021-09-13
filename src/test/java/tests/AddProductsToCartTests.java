package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class AddProductsToCartTests extends BaseTest {

    @Test(description = "checking that product has been added to cart")
    public void addProductToCartTest() {
        authorizationSteps.signInToAccount(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        addProductToCartSteps.addNewProduct(WOMEN, DOLLAR, SUMMER_DRESSES, SHOW_DROPDOWN, SHOW_DROPDOWN_24, SORT_BY_DROPDOWN, PRICE_LOWEST_FIRST,
                VIEW_AS_LIST, SUMMER_DRESS_PRODUCT_PRICE);
        Assert.assertEquals(productCategoryPage.getProductNameByPrice(SUMMER_DRESS_PRODUCT_PRICE), "Printed Maxi Dress");
    }

    @Test(description = "checking that two products has been added to cart")
    public void addMultiplyProductToCartTest() {
        authorizationSteps.signInToAccount(System.getProperty("email", PropertyReader.getProperty("email")),
                System.getProperty("password", PropertyReader.getProperty("password")));
        addProductToCartSteps.addTwoProducts(WOMEN, DOLLAR, SUMMER_DRESSES, SHOW_DROPDOWN, SHOW_DROPDOWN_24, SORT_BY_DROPDOWN, PRICE_LOWEST_FIRST,
                VIEW_AS_LIST, SUMMER_DRESS_PRODUCT_PRICE, ROYAL_BLUE_DRESS);
        Assert.assertEquals(cartPage.getCountOfProducts(),2);
    }
}
