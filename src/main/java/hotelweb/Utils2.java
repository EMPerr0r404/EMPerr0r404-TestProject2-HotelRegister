package hotelweb;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class Utils2 {
    // Sprawdza, czy element jest widoczny i aktywny
    public static void assertDisplayedAndEnabled(WebElement elem) {
        if (!elem.isDisplayed() || !elem.isEnabled()) {
            Assertions.fail("Element is NOT displayed OR NOT enabled!");
        }
    }

    // Generuje losowy adres e-mail na podstawie UUID
    public static String generateRandomEmail() {
        return UUID.randomUUID().toString() + "@mail.pl";
    }

    // Ustawia stan checkboxa na podstawie wartości isChecked
    public static void setCheckbox(WebElement checkbox, boolean isChecked) {
        if ((isChecked && (checkbox.getAttribute("checked") == null)) ||
                (!isChecked && (checkbox.getAttribute("checked") != null))
        ) {
            checkbox.click();
        }
    }
}