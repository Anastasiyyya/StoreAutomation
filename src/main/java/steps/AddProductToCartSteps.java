package steps;

import pages.HeaderPage;

public class AddProductToCartSteps {

    private final HeaderPage headerPage;

    public AddProductToCartSteps() {
        headerPage = new HeaderPage();
    }

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
                .clickProceedToCheckoutButtonFromModal();
        return this;
    }

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
                .clickProceedToCheckoutButtonFromModal();
        return this;
    }
}
