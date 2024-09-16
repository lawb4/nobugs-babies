package lecture4ui.practice.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lecture4ui.practice.ui.data.BankAccount;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {

    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {

        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());

        registerButton.click();
    }
}