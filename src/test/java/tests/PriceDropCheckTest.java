package tests;

import components.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class PriceDropCheckTest extends BaseTest {
    @Test(groups = "ProductsTests")
    public void checkThatEveryProductHasOldAndNewPriceAndPromoPriceCalculatesCorrect() {

        MainPage mainPage = new MainPage();
        SoftAssertions softAssertions = new SoftAssertions();
        List<Product> allPricesDropProducts = mainPage.clickOnThePricesDropLink().getAllPricesDropProducts();


        for (Product product : allPricesDropProducts) {

            double expectedPromoPrice = product.getOldPriceAsDouble() - (product.getOldPriceAsDouble() / 100 * product.getDiscountValue());

            softAssertions.assertThat(product.getPriceAsDouble())
                    .as("Promo price calculates uncorrect")
                    .isEqualTo(Math.floor(expectedPromoPrice * 1e2) / 1e2);

            softAssertions.assertThat(product.getOldPriceAsDouble())
                    .as("Product has no old price, or new price")
                    .isNotNull();

            softAssertions.assertThat(product.getPriceAsDouble())
                    .as("Product has no old price, or new price")
                    .isNotNull();

            softAssertions.assertAll();
        }
    }
}
