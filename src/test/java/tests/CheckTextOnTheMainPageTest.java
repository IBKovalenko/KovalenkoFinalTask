package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckTextOnTheMainPageTest extends BaseTest {

    @Test(groups = "TestsOnMainPage")
    public void checkOfInscriptionsOnTheMainPage() {

        MainPage mainPage = new MainPage();

        String actualTextGetOurLatestNewsAndSpecialSales = mainPage.getOurLatestNewsAndSpecialSalesText();
        String actualTexUnsubscribeNotification = mainPage.getUnsubscribeNotificationText();
        String actualTexSubscribeButton = mainPage.getSubscribeButtonText();
        Boolean isTextOnSubscribeButtonInUppercase = mainPage.isTextInUppercase();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualTextGetOurLatestNewsAndSpecialSales)
                .as("Actual text not as expected")
                .isEqualTo("Get our latest news and special sales");

        softAssertions.assertThat(actualTexUnsubscribeNotification)
                .as("Actual text not as expected")
                .isEqualTo("You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.");

        softAssertions.assertThat(actualTexSubscribeButton)
                .as("Actual text not as expected")
                .isEqualToIgnoringCase("subscribe");

        softAssertions.assertThat(isTextOnSubscribeButtonInUppercase)
                .as("Text on subscribe button is not in uppercase")
                .isEqualTo(true);

        softAssertions.assertAll();

    }

}
