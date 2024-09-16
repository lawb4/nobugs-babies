package lecture4ui.homework.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class SuccessfulRegistrationPage {

    // Headings
    private SelenideElement rightPanelWithWelcomeUsernameHeading =
            element(Selectors.byCssSelector("#rightPanel h1.title"));

    // Onscreen Text
    private SelenideElement rightPanelWithWelcomeSuccessfulAccountCreationText =
            element(Selectors.byCssSelector("#rightPanel p"));
}