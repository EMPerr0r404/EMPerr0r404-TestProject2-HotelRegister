package hotelweb;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelMainPage {

    @FindBy(css = "a.user_login.navigation-link")
    private WebElement signInButton; // Przycisk do logowania

    @FindBy(id = "hotel_cat_name")
    private WebElement hotelList; // Lista hoteli

    @FindBy(css = "#search_hotel_block_form > div:nth-child(2) > div > ul > li")
    private WebElement hotelPrime; // Wybór hotelu

    @FindBy(id = "check_in_time")
    private WebElement checkIn; // Pole wyboru daty zameldowania

    @FindBy(id = "check_out_time")
    private WebElement checkOut; // Pole wyboru daty wymeldowania

    @FindBy(id = "search_room_submit")
    private WebElement searchHotelButton; // Przycisk wyszukiwania hoteli

    public HotelMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this); // Inicjalizacja elementów strony przy użyciu PageFactory
    }

    public void clickSignIn() {
        signInButton.click(); // Kliknięcie przycisku logowania
    }

    public void hotelSearch() {
        hotelList.click(); // Kliknięcie na listę hoteli
        hotelPrime.click(); // Wybór konkretnego hotelu
        checkIn.click(); // Kliknięcie w pole daty zameldowania
        checkIn.sendKeys(Keys.ENTER); // Wybór daty zameldowania i zatwierdzenie Enterem
        checkOut.click(); // Kliknięcie w pole daty wymeldowania
        checkOut.sendKeys(Keys.ENTER); // Wybór daty wymeldowania i zatwierdzenie Enterem
        searchHotelButton.click(); // Kliknięcie przycisku wyszukiwania hoteli
    }
}