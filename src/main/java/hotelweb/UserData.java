package hotelweb;
public class UserData {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private boolean isMr;
    private boolean isSignUpForNewsletter;

    public UserData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    // Ustawia nazwisko i zwraca obiekt UserData
    public UserData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    // Ustawia hasło i zwraca obiekt UserData
    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    // Ustawia adres e-mail i zwraca obiekt UserData
    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }

    // Ustawia informację o płci (Mr/Mrs) i zwraca obiekt UserData
    public UserData setMr(boolean mr) {
        isMr = mr;
        return this;
    }

    // Ustawia informację o subskrypcji newslettera i zwraca obiekt UserData
    public UserData setSignUpForNewsletter(boolean signUpForNewsletter) {
        isSignUpForNewsletter = signUpForNewsletter;
        return this;
    }

    // Pobiera imię
    public String getFirstName() {
        return firstName;
    }

    // Pobiera nazwisko
    public String getLastName() {
        return lastName;
    }

    // Pobiera hasło
    public String getPassword() {
        return password;
    }

    // Pobiera adres e-mail
    public String getEmail() {
        return email;
    }

    // Sprawdza, czy użytkownik jest uznawany za mężczyznę (Mr)
    public boolean isMr() {
        return isMr;
    }

    // Sprawdza, czy użytkownik jest zapisany na newsletter
    public boolean isSignUpForNewsletter() {
        return isSignUpForNewsletter;
    }
}