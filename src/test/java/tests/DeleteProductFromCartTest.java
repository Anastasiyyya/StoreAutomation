package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class DeleteProductFromCartTest extends BaseTest {

    @Test(description = "checking that product has been deleted from cart")
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
                .clickContinueShoppingButton()
                .selectProductByName("Royal Blue  Dress")
                .addProductToCart()
                .clickProceedToCheckoutButton()
                .findProductByNameAndDelete("Printed Maxi Dress");
        Assert.assertEquals(cartPage.getCountOfProducts(),1);
    }
}
