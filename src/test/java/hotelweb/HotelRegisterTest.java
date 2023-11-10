package hotelweb;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // Ustawia, że klasa `HotelRegisterTest` będzie używana do uruchamiania testów Cucumber.

@CucumberOptions(features = "src/test/resources/features/HotelCucu.feature", // Wskazuje ścieżkę do pliku .feature z opisem testów Cucumber.

        plugin = {"pretty",  // Plugin "pretty" generuje czytelny wynik testów w konsoli.
                "json:target/cucumber-reports/Cucumber.json",  // Plugin "json" generuje raport w formacie JSON.
                "junit:target/cucumber-reports/HotelCucumber.xml",  // Plugin "junit" generuje raport w formacie JUnit XML.
                "html:target/cucumber-reports/HotelCucumber-report.html"  // Plugin "html" generuje raport w formacie HTML.
        })
public class HotelRegisterTest {
}