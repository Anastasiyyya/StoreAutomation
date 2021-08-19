package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class SearchProductTests extends BaseTest {

    @Test(description = "checking that product has been deleted from cart")
    public void searchProductTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage
                .searchProduct(PRINTED_MAXI_DRESS);
        Assert.assertTrue(productCategoryPage.isProductListNotEmpty());
    }

    @Test(description = "checking that product has been deleted from cart")
    public void searchWithEmptyDataTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage
                .searchProduct("");
        Assert.assertEquals(productCategoryPage.getSearchMessageText(), "Please enter a search keyword");
    }
}
