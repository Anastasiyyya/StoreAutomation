package page_constants;

public interface IConstants {

    String STORE_AUTOMATION_BASE_URL = "http://automationpractice.com/index.php/";
    String STORE_AUTOMATION_AUTHORIZATION_PAGE_URL = STORE_AUTOMATION_BASE_URL + "?controller=authentication&back=my-account";
    String STORE_AUTOMATION_MY_ADDRESSES_PAGE_URL = STORE_AUTOMATION_BASE_URL + "?controller=addresses";
    String STORE_AUTOMATION_ORDER_HISTORY_PAGE_URL = STORE_AUTOMATION_BASE_URL + "?controller=history";
    String STORE_AUTOMATION_WISHLISTS_PAGE_URL = STORE_AUTOMATION_BASE_URL + "?fc=module&module=blockwishlist&controller=mywishlist";
}
