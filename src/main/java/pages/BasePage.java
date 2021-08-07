package pages;

import pageConstants.IConstants;
import static com.codeborne.selenide.Selenide.open;

public class BasePage implements IConstants {

    /**
     * This method opens page by URL
     * @param url
     */
    public void openPage(String url){
        open(url);
    }
}
