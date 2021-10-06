package tests;


import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;
import java.util.List;
import java.util.stream.Collectors;

public class SortingCheckTest extends BaseTest {


    @Test
    public void checkTheCorrectSortByNameAndByPriceTest() {

        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();

        AllProductsPage allProductsPage = mainPage.clickOnTheAllProductsLink();
        List<String> expectedAllProductsByNamesSort = allProductsPage.getAllProductsNames(2)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> actualAllProductsByNamesSort = allProductsPage.clickOnTheSortByMenuButton()
                .clickOnTheSortByNameAToZButton().getAllProductsNames(2);


        softAssertions.assertThat(actualAllProductsByNamesSort)
                .as("Sort by name uncorrect")
                .isEqualTo(expectedAllProductsByNamesSort);

        softAssertions.assertAll();
    }
}
