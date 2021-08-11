package pages;

import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class MyAccountPage extends CreateAccountPage{

    public static final String CREATED_ACCOUNT_MESSAGE_XPATH = "//*[@id='center_column']//p";
    public static final String ACCOUNT_NAME_TEXT_XPATH = "//*[@class='header_user_info']//span";

    public String getInfoMessageText(String path) {
        return $(By.xpath(path)).getText();
    }
}
