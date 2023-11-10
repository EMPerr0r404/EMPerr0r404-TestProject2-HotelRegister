package hotelweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMyAccountPage {

    @FindBy(css = "p.alert.alert-success")
    private WebElement accountCreationSuccessPanel; // Panel sukcesu tworzenia konta

    public HotelMyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this); // Inicjalizacja elementów strony przy użyciu PageFactory
    }

    public boolean isAccountCreationSuccessPanelDisplayed() {
        return "Your account has been created.".equals(accountCreationSuccessPanel.getText());
        // Sprawdzenie, czy panel sukcesu zawiera oczekiwany tekst "Your account has been created."
    }
}