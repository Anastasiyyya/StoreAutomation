package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class AddProductsToCartTests extends BaseTest {

    @Test(description = "checking that product has been added to cart")
    public void addProductToCartTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage.moveToMenuButton("Women")
                .changeCurrencyTo("Доллар")
                .moveAndClickOnSubMenuButton("Summer Dresses")
                .chooseDropdownAndOption("Show","24")
                .chooseDropdownAndOption("Sort by", "Price: Lowest first")
                .changeViewTo("list")
                .selectProductByPrice("$27.43")
                .addProductToCart()
                .clickProceedToCheckoutButton();
        Assert.assertEquals(productCategoryPage.getProductNameByPrice("27.43"), cartPage.getProductName("Printed Maxi Dress"));
    }

    @Test(description = "checking that two products has been added to cart")
    public void addMultiplyProductToCartTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage.moveToMenuButton("Women")
                .changeCurrencyTo("Доллар")
                .moveAndClickOnSubMenuButton("Summer Dresses")
                .chooseDropdownAndOption("Show","24")
                .chooseDropdownAndOption("Sort by", "Price: Lowest first")
                .changeViewTo("list")
                .selectProductByPrice("$27.43")
                .addProductToCart()
                .clickContinueShoppingButton()
                .selectProductByName("Royal Blue  Dress")
                .addProductToCart()
                .clickProceedToCheckoutButton();
        Assert.assertEquals(cartPage.getCountOfProducts(),2);
    }
}
