package lecture4ui.practice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import lecture4ui.practice.ui.data.BankAccount;
import lecture4ui.practice.ui.pages.RegisterAccountPage;
import lecture4ui.practice.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleUiTest {

    @BeforeAll
    public static void setupUiTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "safari";
        //Configuration.timeout = 5000;
    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

    }
}
