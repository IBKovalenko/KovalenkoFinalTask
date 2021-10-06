package tests;


import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckTheNumberOfLanguagesTest extends BaseTest {

    @Test(groups = "TestsOnMainPage")
    public void checkTheNumberOfLanguagesInSelectMenuAndExistUkraineLanguage() {

        MainPage mainPage = new MainPage();

        List<String> allLanguages = mainPage.getAllLanguagesList();

        SoftAssertions softAssertions = new SoftAssertions();

        assertThat(allLanguages)
                .as("Number of languages is not as expected")
                .hasSize(44);

        assertThat(allLanguages)
                .as("Ukraine language is not exist")
                .contains("Українська");

        softAssertions.assertAll();

    }
}
