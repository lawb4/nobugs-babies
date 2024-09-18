package lecture4ui.homework.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lecture4ui.homework.ui.data.BankAccount;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.element;
import static lecture4ui.homework.utils.Helpers.setInputIfNotNull;

@Getter
public class RegisterAccountPage {
    // Inputs
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));

    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));

    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));

    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));

    private SelenideElement phoneInput = element(Selectors.byId("customer.phoneNumber"));

    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));

    private SelenideElement usernameInput = element(Selectors.byId("customer.username"));

    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));

    private SelenideElement repeatedPasswordInput = element(Selectors.byId("repeatedPassword"));

    // Buttons
    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    // Errors
    private SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));

    private SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));

    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    private SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

    private SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

    private SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

    private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

    private SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));

    private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

    private SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));

    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {

        setInputIfNotNull(firstNameInput, bankAccount.getFirstName());
        setInputIfNotNull(lastNameInput, bankAccount.getLastName());
        setInputIfNotNull(addressInput, bankAccount.getAddress());
        setInputIfNotNull(cityInput, bankAccount.getCity());
        setInputIfNotNull(stateInput, bankAccount.getState());
        setInputIfNotNull(zipCodeInput, bankAccount.getZipCode());
        setInputIfNotNull(phoneInput, bankAccount.getPhone());
        setInputIfNotNull(ssnInput, bankAccount.getSsn());
        setInputIfNotNull(usernameInput, bankAccount.getUsername());
        setInputIfNotNull(passwordInput, bankAccount.getPassword());
        setInputIfNotNull(repeatedPasswordInput, bankAccount.getRepeatedPassword());
        setInputIfNotNull(firstNameInput, bankAccount.getFirstName());

        registerButton.click();
    }
}