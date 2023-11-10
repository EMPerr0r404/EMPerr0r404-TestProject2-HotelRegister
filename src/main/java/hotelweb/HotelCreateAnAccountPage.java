package hotelweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hotelweb.Utils2.assertDisplayedAndEnabled;
import static hotelweb.Utils2.setCheckbox;

public class HotelCreateAnAccountPage {

    @FindBy(id = "submitAccount")
    protected WebElement registerButton; // Przycisk do zarejestrowania nowego konta

    @FindBy(id = "customer_firstname")
    protected WebElement firstNameInput; // Pole do wprowadzania imienia użytkownika

    @FindBy(id = "customer_lastname")
    protected WebElement lastNameInput; // Pole do wprowadzania nazwiska użytkownika

    @FindBy(id = "passwd")
    protected WebElement passwordInput; // Pole do wprowadzania hasła

    @FindBy(id = "newsletter")
    protected WebElement newsletterCheckbox; // Pole wyboru subskrypcji newslettera

    @FindBy(id = "id_gender1")
    protected WebElement radioButtonMr; // Przycisk wyboru tytułu "Pan"

    @FindBy(id = "id_gender2")
    protected WebElement radioButtonMrs; // Przycisk wyboru tytułu "Pani"

    public HotelCreateAnAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this); // Inicjalizacja elementów strony przy użyciu PageFactory
    }

    public void clickRegisterButton() {
        assertDisplayedAndEnabled(registerButton); // Sprawdzenie, czy przycisk jest widoczny i aktywny
        registerButton.click(); // Kliknięcie przycisku rejestracji
    }

    public void fillForm(UserData userData) {
//        assertDisplayedAndEnabled(firstNameInput);
//        assertDisplayedAndEnabled(lastNameInput);
//        assertDisplayedAndEnabled(passwordInput);
//        assertDisplayedAndEnabled(newsletterCheckbox);

        if (userData.isMr()) {
            radioButtonMr.click(); // Wybór tytułu "Pan" jeśli użytkownik jest mężczyzną
        } else {
            radioButtonMrs.click(); // Wybór tytułu "Pani" jeśli użytkownik jest kobietą
        }

        firstNameInput.sendKeys(userData.getFirstName()); // Wprowadzenie imienia
        lastNameInput.sendKeys(userData.getLastName()); // Wprowadzenie nazwiska
        passwordInput.sendKeys(userData.getPassword()); // Wprowadzenie hasła
        setCheckbox(newsletterCheckbox, userData.isSignUpForNewsletter()); // Ustawienie pola wyboru subskrypcji newslettera
    }
}