package pages;

import components.Product;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class DiscountProductPage extends BasePage {

    public DiscountProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='product']")
    private List<WebElement> pricesDropProductsContainers;


    public List<Product> getAllPricesDropProducts() {
        log.info("get list all prices drop products");
        List<Product> allPricesDropProducts = new ArrayList<>();
        for (WebElement container : pricesDropProductsContainers) {
            waitUntilVisible(By.xpath(".//div[@itemprop='itemListElement']"), 3);
            allPricesDropProducts.add(new Product(container));
        }
        return allPricesDropProducts;
    }
}
