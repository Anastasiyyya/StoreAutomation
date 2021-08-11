package pages;

import lombok.Data;

import static com.codeborne.selenide.Selenide.$;

@Data
public class MyAccountPage extends HeaderPage {

    public static final String CREATED_ACCOUNT_MESSAGE_CSS = "#center_column p";
    public static final String ACCOUNT_NAME_TEXT_CSS = ".header_user_info span";

    public String getText(String path) {
        return $(path).getText();
    }
}
