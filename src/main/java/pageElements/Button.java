package pageElements;

import com.codeborne.selenide.Condition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Button {

    String label;

    /**
     * This method waits until a button should be visible.
     * @param button
     */
    public void waitForButtonVisible(String button) {
        $(button).shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}
