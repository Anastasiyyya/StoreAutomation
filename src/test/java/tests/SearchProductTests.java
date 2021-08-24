package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class SearchProductTests extends BaseTest {

    @Test(description = "checking that the product list not empty")
    public void searchAnyProductTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage
                .searchProduct(PRINTED_MAXI_DRESS);
        Assert.assertTrue(productCategoryPage.isProductListNotEmpty());
    }

    @Test(description = "checking that the error message is displayed when the search request is empty")
    public void searchWithEmptyDataTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage
                .searchProduct("");
        Assert.assertEquals(productCategoryPage.getSearchMessageText(), "Please enter a search keyword");
    }

    @Test(description = "checking that the product list not empty")
    public void searchProductTest() {
        authorizationSteps.signInToAccount(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage
                .searchProduct(LIGHT_GREEN_THIN_SWEATER);
        Assert.assertTrue(productCategoryPage.checkIfTheProductDisplayed(LIGHT_GREEN_THIN_SWEATER));
    }
}
