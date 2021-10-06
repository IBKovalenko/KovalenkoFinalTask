package tests;

import components.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class CheckPopularProductsTest extends BaseTest {

    @Test(groups = "ProductsTests")
    public void checkThatEveryProductHasNameAndPriceBiggerThanZero() {

        MainPage mainPage = new MainPage();

        SoftAssertions softAssertions = new SoftAssertions();

        List<Product> allProducts = mainPage.getAllPopularProductsFromPage();

        for (Product product : allProducts) {
            double actualPrice = product.getPriceAsDouble();

            softAssertions.assertThat(product.getName())
                    .as("Product has no name")
                    .isNotNull();

            softAssertions.assertThat(product.getPrice())
                    .as("Product has no price")
                    .isNotNull();

            softAssertions.assertThat(actualPrice)
                    .as("Product price <= zero")
                    .isGreaterThan(0);

            softAssertions.assertAll();
        }
    }
}
