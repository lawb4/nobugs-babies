package lecture4ui.homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Vladimir");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Viktorovich");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

    }

    @Test
    public void userCanNotCreateAccountWithAddressOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Lenina Street");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithCityOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Madrid");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithStateOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Community of Madrid");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithZipCodeOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("123456");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithSocialSecurityNumberOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("123456789");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithUsernameOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement username = element(Selectors.byId("customer.username"));
        username.sendKeys("V0w@n4eG");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithPasswordOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("P@zV0rrD");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithRepeatedPasswordOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("P@zV0rrD");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));
    }

    @Test
    public void userCanCreateAccount() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Vladimir");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Viktorovich");

        SelenideElement address = element(Selectors.byId("customer.address.street"));
        address.sendKeys("Lenina Street");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Madrid");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Community of Madrid");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("123456");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("123456789");

        SelenideElement username = element(Selectors.byId("customer.username"));
        String usernameString = "V0w@n4eG12";
        username.sendKeys(usernameString);

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("P@zV0rrD");

        SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));
        repeatedPassword.sendKeys("P@zV0rrD");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement rightPanelWithWelcomeHeading = element(Selectors.byCssSelector("#rightPanel h1.title"));
        rightPanelWithWelcomeHeading.shouldHave(Condition.text(String.format("Welcome %s", usernameString)));
    }
}
