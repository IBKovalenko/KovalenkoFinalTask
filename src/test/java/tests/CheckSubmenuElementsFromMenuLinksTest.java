package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckSubmenuElementsFromMenuLinksTest extends BaseTest {

    @Test(groups = "TestsOnMainPage")
    public void checkCorrectDisplayOfSubmenuItemsAfterHoveringOverTheCourseOnClothesAccessoriesAndArtMenu() {

        MainPage mainPage = new MainPage();

        List<String> expectedValuesFromClothesMenu = new ArrayList<>((Arrays.asList("MEN", "WOMEN")));
        List<String> expectedValuesFromAccessoriesMenu = new ArrayList<>((Arrays.asList("STATIONERY", "HOME ACCESSORIES")));


        List<String> actualValuesFromClothesMenu = mainPage
                .moveMouseToClothesMenu()
                .getAllSubmenuElementsAfterHoveringOverTheCourse("CLOSES");

        List<String> actualValuesFromAccessoriesMenu = mainPage
                .moveMouseToAccessoriesMenu()
                .getAllSubmenuElementsAfterHoveringOverTheCourse("ACCESORIES");

        List<String> actualValuesFromArtMenu = mainPage
                .moveMouseToArtMenu()
                .getAllSubmenuElementsAfterHoveringOverTheCourse("ART");

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualValuesFromClothesMenu)
                .as("Actual appeared items from clothes menu are not as expected")
                .isEqualTo(expectedValuesFromClothesMenu);

        softAssertions.assertThat(actualValuesFromAccessoriesMenu)
                .as("Actual appeared items from accessories menu are not as expected")
                .isEqualTo(expectedValuesFromAccessoriesMenu);

        softAssertions.assertThat(actualValuesFromArtMenu)
                .as("Any items should not be displayed")
                .hasSize(0);

        softAssertions.assertAll();
    }
}
