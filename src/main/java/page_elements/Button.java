package page_elements;

import com.codeborne.selenide.Condition;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Data
@NoArgsConstructor
@Builder
public class Button {

    String label;

    public static final String BUTTON_XPATH = "//*[contains(@class,'btn') and .//*[contains(.,'%s')]]";

    public Button(String label) {
        this.label = label;
    }

    public void click() {
        $x(String.format(BUTTON_XPATH, label)).click();
    }

    /**
     * This method waits until a button should be visible with using button label.
     * @param label
     */
    public void waitForButtonVisibleByLabel(String label) {
        $x(String.format(BUTTON_XPATH, label)).shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    /**
     * This method waits until a button should be visible with using xpath for button.
     * @param button
     */
    public void waitForButtonVisible(String button) {
        $(button).shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void clickButton(String button) {
        $(button).click();
    }
}
