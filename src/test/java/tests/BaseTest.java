package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.AddNewAddressSteps;
import steps.AddProductToCartSteps;
import steps.AuthorizationSteps;
import steps.CreateAccountSteps;
import test_data.ITestConstants;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest implements ITestConstants {

    BasePage basePage =  new BasePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CreateAccountSteps createAccountSteps =  new CreateAccountSteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    HeaderPage headerPage;
    ProductCategoryPage productCategoryPage;
    CartPage cartPage;
    QuickViewProductModalPage quickViewProductModalPage;
    AddNewAddressSteps addNewAddressSteps;
    MyAddressesPage myAddressesPage;
    AddProductToCartSteps addProductToCartSteps;

    /**
     * This method performed before the test.
     */
    @BeforeMethod
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        initPages();
    }

    /**
     * This method executed after test methods and closes browser.
     */
    @AfterMethod
    public void closeBrowser(){
        getWebDriver().quit();
    }

    /**
     * This method inits pages for this project
     */
    public void initPages() {
        basePage =  new BasePage();
        createAccountSteps = new CreateAccountSteps();
        myAccountPage = new MyAccountPage();
        authorizationSteps =  new AuthorizationSteps();
        headerPage = new HeaderPage();
        productCategoryPage = new ProductCategoryPage();
        cartPage = new CartPage();
        quickViewProductModalPage = new QuickViewProductModalPage();
        myAccountPage = new MyAccountPage();
        addNewAddressSteps = new AddNewAddressSteps();
        myAddressesPage = new MyAddressesPage();
        addProductToCartSteps = new AddProductToCartSteps();
    }
}

