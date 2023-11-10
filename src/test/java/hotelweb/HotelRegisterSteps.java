package hotelweb;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

import static hotelweb.Utils2.assertDisplayedAndEnabled;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HotelRegisterSteps {
    public WebDriver driver;
    private HotelAuthenticationPage authenticationPage;
    private HotelMainPage mainPage;
    private HotelCreateAnAccountPage createAnAccountPage;
    private HotelMyAccountPage myAccountPage;

    @Given("Page {string} opened in browser")
    public void pageOpen(String url) {
        // Inicjalizacja przeglądarki Chrome
        driver = new ChromeDriver();
        // Ustawienie czasu oczekiwania na elementy
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Maksymalizacja okna przeglądarki
        driver.manage().window().maximize();
        // Otwarcie wskazanej strony
        driver.get(url);
        // Inicjalizacja stron za pomocą PageFactory
        authenticationPage = new HotelAuthenticationPage(driver);
        mainPage = new HotelMainPage(driver);
        createAnAccountPage = new HotelCreateAnAccountPage(driver);
        myAccountPage = new HotelMyAccountPage(driver);
    }

    @When("Button SignIn clicked")
    public void buttonSignInClicked() {
        // Kliknięcie przycisku logowania
        mainPage.clickSignIn();
    }

    @And("Email filled and ENTER pushed")
    public void emailFilled() {
        // Generowanie losowego adresu e-mail
        final String randomEmail = Utils2.generateRandomEmail();
        // Wprowadzenie adresu e-mail i naciśnięcie klawisza ENTER
        authenticationPage.fillCreateAnAccount(randomEmail + Keys.ENTER);
    }

    @And("^form filled with (.*),(.*),(.*)$")
    public void formFilled(String firstName, String lastName, String password) {
        assertDisplayedAndEnabled(createAnAccountPage.firstNameInput);
        assertDisplayedAndEnabled(createAnAccountPage.lastNameInput);
        assertDisplayedAndEnabled(createAnAccountPage.passwordInput);
        assertDisplayedAndEnabled(createAnAccountPage.newsletterCheckbox);

        // Wypełnienie formularza danymi użytkownika
        UserData userData = new UserData()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMr(false)
                .setPassword(password)
                .setSignUpForNewsletter(true);
        createAnAccountPage.fillForm(userData);
    }

    @And("Button Register clicked")
    public void buttonRegisterClicked() {
        // Kliknięcie przycisku "Register"
        createAnAccountPage.clickRegisterButton();
    }

    @Then("Check if account created")
    public void checkIfAccountCreated() {
        // Sprawdzenie, czy konto zostało utworzone
        assertTrue(myAccountPage.isAccountCreationSuccessPanelDisplayed());
    }

    @And("Save screenshot")
    public void saveScreenshot() throws IOException {
        // Zapisanie zrzutu ekranu
        File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Kopiowanie zrzutu ekranu do określonej lokalizacji
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test", "ggl-search" + currentDateTime + ".png"));
    }

    @Then("Close browser")
    public void closeBrowser() {
        System.out.println("We close the browser, are we not?");
        // Zamknięcie przeglądarki
        // driver.quit();
    }
}