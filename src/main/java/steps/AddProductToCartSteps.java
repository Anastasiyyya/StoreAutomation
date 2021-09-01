package steps;

import io.qameta.allure.Step;
import pages.HeaderPage;

public class AddProductToCartSteps {

    private final HeaderPage headerPage;

    public AddProductToCartSteps() {
        headerPage = new HeaderPage();
    }

    @Step("Adding new product to cart")
    public AddProductToCartSteps addNewProduct(String menuButton, String newCurrency, String subMenuButton, String showDropdown,
                                               String showQuantityOfProducts, String sortByDropdown, String sortBy, String view, String productName) {
        headerPage
                .moveToMenuButton(menuButton)
                .changeCurrencyTo(newCurrency)
                .moveAndClickOnSubMenuButton(subMenuButton)
                .chooseDropdownAndOption(showDropdown,showQuantityOfProducts)
                .chooseDropdownAndOption(sortByDropdown, sortBy)
                .changeViewTo(view)
                .selectProductByPrice(productName)
                .addProductToCart()
                .clickProceedToCheckoutButton();
        return this;
    }

    @Step("Adding two products to cart")
    public AddProductToCartSteps addTwoProducts(String menuButton, String newCurrency, String subMenuButton, String showDropdown,
                                                String showQuantityOfProducts, String sortByDropdown, String sortBy, String view, String firstProductName, String secondProductName) {
        headerPage.moveToMenuButton(menuButton)
                .changeCurrencyTo(newCurrency)
                .moveAndClickOnSubMenuButton(subMenuButton)
                .chooseDropdownAndOption(showDropdown,showQuantityOfProducts)
                .chooseDropdownAndOption(sortByDropdown, sortBy)
                .changeViewTo(view)
                .selectProductByPrice(firstProductName)
                .addProductToCart()
                .clickContinueShoppingButton()
                .selectProductByName(secondProductName)
                .addProductToCart()
                .clickProceedToCheckoutButton();
        return this;
    }
}
