package hotelweb;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelAuthenticationPage {

    @FindBy(id = "email_create")
    private WebElement emailInput; // Pole do wprowadzania adresu e-mail podczas tworzenia konta

    @FindBy(id = "email")
    private WebElement email; // Pole do wprowadzania adresu e-mail podczas logowania

    @FindBy(id = "passwd")
    private WebElement password; // Pole do wprowadzania hasła podczas logowania

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin; // Przycisk do zatwierdzania logowania

    @FindBy(id = "header_logo")
    private WebElement headerLogo; // Logo strony głównej

    public HotelAuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this); // Inicjalizacja elementów strony przy użyciu PageFactory
    }

    public void fillCreateAnAccount(String input) {
        emailInput.sendKeys(input); // Wprowadzenie adresu e-mail podczas tworzenia konta
    }

    public void login(UserData userData) {
        email.sendKeys(userData.getEmail()); // Wprowadzenie adresu e-mail podczas logowania
        password.sendKeys(userData.getPassword()); // Wprowadzenie hasła podczas logowania
        submitLogin.click(); // Kliknięcie przycisku logowania
    }

    public void navigateToMain() {
        headerLogo.click(); // Kliknięcie na logo strony głównej, aby wrócić na stronę główną
    }
}