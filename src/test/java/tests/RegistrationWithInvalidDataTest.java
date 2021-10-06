package tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterAccountPage;
import utils.FakeDataGenerator;

public class RegistrationWithInvalidDataTest extends BaseTest {

    @Test(groups = "LoginAndRegisterAccount")
    public void registrationWithInvalidFirstName() {

        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();
        MainPage mainPage = new MainPage();

        String firstName = "James8";

        RegisterAccountPage registerAccountPage = (RegisterAccountPage) mainPage
                .clickOnSignInButton()
                .clickOnTheCreateAccountLink()
                .selectMrCheckBox()
                .enterFirstName(firstName)
                .enterLastName(fakeDataGenerator.getLastName())
                .enterEmaile(fakeDataGenerator.getEmail())
                .enterPassword(fakeDataGenerator.getPassword())
                .enterBirthdate("04/15/1988")
                .clickCustomerDataPrivacyCheckBox()
                .clickAgreeToTheTermsAndConditionsCheckBox()
                .clickOnSaveAccountButton(false);

        String actualInvalidFormatFirstNameMessage = registerAccountPage.getInvalidFormatFirstNameMessage();
        String actualBorderColour = registerAccountPage.getFirstNameFieldBorderColourAfterInvalidDataSet();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualInvalidFormatFirstNameMessage)
                .as("Actual text not as expected")
                .isEqualTo("Invalid name");

        softAssertions.assertThat(actualBorderColour)
                .as("Actual border colour not as expected")
                .contains("rgb(255, 76, 76)");

        softAssertions.assertAll();

    }
}
