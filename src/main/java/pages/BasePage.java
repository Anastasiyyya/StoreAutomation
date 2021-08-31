package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import page_constants.IConstants;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class BasePage implements IConstants {

    /**
     * This method opens page by URL
     * @param url
     */
    @Step("Opening page by {url}}")
    public void openPage(String url){
        log.info(String.format("Open page by URL: '%s'", url));
        open(url);
    }
}
