package tests;


import org.testng.annotations.Test;
import pages.MainPage;
import pages.MainPageAfterSignInOrRegister;
import utils.FakeDataGenerator;

import static org.assertj.core.api.Assertions.assertThat;



public class AccountCreateTest extends BaseTest {

    @Test(groups = "LoginAndRegisterAccount")
    public void checkThatNewAccountIsCreated() {
        FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();

        MainPage mainPage = new MainPage();

        String firstName = fakeDataGenerator.getFirstName();
        String lastName = fakeDataGenerator.getLastName();

        MainPageAfterSignInOrRegister mainPageAfterSignInOrRegister = (MainPageAfterSignInOrRegister) mainPage
                .clickOnSignInButton()
                .clickOnTheCreateAccountLink()
                .selectMrCheckBox()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmaile(fakeDataGenerator.getEmail())
                .enterPassword(fakeDataGenerator.getPassword())
                .enterBirthdate("04/15/1988")
                .clickCustomerDataPrivacyCheckBox()
                .clickAgreeToTheTermsAndConditionsCheckBox()
                .clickOnSaveAccountButton(true);

        String actualFirstAndLastNameAppears = mainPageAfterSignInOrRegister.getFirstNameAndLastNameAppears();
        assertThat(actualFirstAndLastNameAppears)
                .as("Message not as expected")
                .isEqualTo(firstName + " " + lastName);
    }

}
