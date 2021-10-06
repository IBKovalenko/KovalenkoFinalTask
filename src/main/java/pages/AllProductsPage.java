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
public class AllProductsPage extends BasePage {

    public AllProductsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='next js-search-link']")
    private WebElement nextProductPageButton;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> containers;


    @FindBy(xpath = "//button[@class='btn-unstyle select-title']")
    private WebElement sortByMenu;

    @FindBy(xpath = "//div[@class='dropdown-menu']//a[3]")
    private WebElement sortByNameAToZButton;

    @FindBy(xpath = "//a[contains(text(),'Name, Z to A')]")
    private WebElement sortByNameZToAButton;

    @FindBy(xpath = "//a[contains(text(),'Price, low to high')]")
    private WebElement sortByPriceLowToHighButton;

    @FindBy(xpath = "//a[contains(text(),'Price, high to low')]")
    private WebElement sortByPriceHighToLowButton;

    @FindBy(xpath = "//a[@class='text-uppercase h6']")
    private WebElement homeButton;

    public AllProductsPage clickOnTheSortByNameAToZButton() {
        waitUntilVisible(By.xpath("//div[@class='dropdown-menu']"), 3);
        sortByNameAToZButton.click();
        waitUntilVisible(By.xpath("//span[@class='spinner']"), 3);
        waitUntilInvisible(By.xpath("//span[@class='spinner']"), 3);
        return this;
    }

    public AllProductsPage clickOnTheSortByNameZToAButton() {
        sortByNameZToAButton.click();
        return this;
    }

    public AllProductsPage clickOnTheSortByPriceLowToHighButton() {
        sortByPriceLowToHighButton.click();
        return this;
    }

    public AllProductsPage clickOnTheSortByPriceHighToLowButton() {
        sortByPriceHighToLowButton.click();
        return this;
    }

    public AllProductsPage clickOnTheSortByMenuButton() {
        waitUntilClickable(By.xpath("//button[@class='btn-unstyle select-title']"), 5);
        sortByMenu.click();
        return this;
    }

    public List<Product> getAllPopularProductsFromPage() {
        List<Product> allProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allProducts.add(new Product(container));
        }
        return allProducts;
    }

    public AllProductsPage clickOnNextProductPageButton() {
        log.info("click on the next product page button");
        waitUntilClickable(By.xpath("//a[@class='next js-search-link']"), 3);
        nextProductPageButton.click();
        waitUntilVisible(By.xpath("//span[@class='spinner']"), 3);
        waitUntilInvisible(By.xpath("//span[@class='spinner']"), 3);
        return this;
    }

    public AllProductsPage clickOnTheHomeButton() {
        log.info("click on the home button");
        waitUntilClickable(By.xpath("//ul[@class='category-top-menu']//a[@class='text-uppercase h6']"), 5);
        homeButton.click();
        return this;
    }


    public List<String> getAllProductsNames(int pageCount) {
        log.info("get list of all products names as string");
        List<String> productNames = new ArrayList<>();
        for (int i = 0; i < pageCount; i++) {
            waitUntilVisible(By.xpath("//div[@class='thumbnail-container reviews-loaded']"), 5);
            for (WebElement container : containers) {
                productNames.add(new Product(container).getNameAsString());
            }
            if (i + 1 < pageCount) {
                clickOnNextProductPageButton();
            } else {
                clickOnTheHomeButton();
            }
        }
        return productNames;
    }
}