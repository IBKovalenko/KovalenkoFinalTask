package pages;

import components.Footer;
import components.Product;
import components.TopMenu;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Getter
public class MainPage extends BasePage {

    Actions action = new Actions(getDriver());
    private TopMenu topMenu;
    private Footer footer;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
        topMenu = new TopMenu(getDriver());
        footer = new Footer(getDriver());
    }

    @FindBy(id = "block-newsletter-label")
    private WebElement getOurLatestNewsAndSpecialSalesText;

    @FindBy(xpath = "//p[starts-with(text(),'You may unsubscribe')]")
    private WebElement unsubscribeNotification;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//li[@id='category-3']")
    private WebElement сlothesMenu;

    @FindBy(xpath = "//li[@id='category-6']")
    private WebElement accessoriesMenu;

    @FindBy(xpath = "//li[@id='category-9']//a")
    private WebElement artMenu;

    @FindBy(xpath = "//a[@class='dropdown-item dropdown-submenu']")
    private List<WebElement> submenuElements;

    @FindBy(xpath = "//div[@class='product']")
    private List<WebElement> containers;

    @FindBy(xpath = "//li[@id='category-3']//li")
    private List<WebElement> closesSubMenus;

    @FindBy(xpath = "//li[@id='category-6']//li")
    private List<WebElement> accessoriesSubMenus;

    @FindBy(xpath = "//li[@id='category-9']//li")
    private List<WebElement> artSubMenus;

    @FindBy(xpath = "//a[@class='all-product-link float-xs-left float-md-right h4']")
    private WebElement allProductsLink;


    public String getOurLatestNewsAndSpecialSalesText() {
        log.info("get text from webelement news and special sales");
        waitUntilVisible(By.id("block-newsletter-label"), 4);
        return getOurLatestNewsAndSpecialSalesText.getText();
    }

    public String getUnsubscribeNotificationText() {
        log.info("get text from webelement unsubscribe notification");
        return unsubscribeNotification.getText();
    }

    public String getSubscribeButtonText() {
        log.info("get text from subscribe button");
        return subscribeButton.getAttribute("value");
    }

    public boolean isTextInUppercase() {
        log.info("check that text in subscribe button is in uppercase");
        return subscribeButton.getCssValue("text-transform").equalsIgnoreCase("uppercase");
    }

    public LoginPage clickOnSignInButton() {
        waitUntilVisible(By.xpath(".//span[contains(text(),'Sign in')]"), 4);
        log.info("click on sign in button");
        topMenu.getSignInButton().click();
        return new LoginPage();
    }

    public MainPage moveMouseToClothesMenu() {
        log.info("move mouse to clothes menu");
        waitUntilVisible(By.xpath("//li[@id='category-3']"), 5);
        action.moveToElement(сlothesMenu).perform();
        return this;
    }

    public MainPage moveMouseToAccessoriesMenu() {
        log.info("move mouse to accessories menu");
        waitUntilVisible(By.xpath("//li[@id='category-6']"), 3);
        action.moveToElement(accessoriesMenu).perform();
        return this;
    }

    public MainPage moveMouseToArtMenu() {
        log.info("move mouse to art menu");
        waitUntilVisible(By.xpath("//li[@id='category-9']"), 3);
        return this;
    }


    public List<String> getAllSubmenuElementsAfterHoveringOverTheCourse(String menu) {
        switch (menu) {
            case "CLOSES":
                log.info("get all elements from clothes menu after hovering over the course");
                waitUntilVisible(By.xpath("//li[@id='category-3']//li"), 5);
                return closesSubMenus.stream().map(WebElement::getText)
                        .map(String::trim)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
            case "ACCESORIES":
                log.info("get all elements from accessories menu after hovering over the course");
                waitUntilVisible(By.xpath("//li[@id='category-6']//li"), 5);
                return accessoriesSubMenus.stream().map(WebElement::getText)
                        .map(String::trim)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
            case "ART":
                log.info("get all elements from art menu after hovering over the course");
                return artSubMenus.stream().map(WebElement::getText)
                        .map(String::trim)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
            default:
                throw new IllegalStateException("Wrong category passed");
        }
    }


    public List<Product> getAllPopularProductsFromPage() {
        log.info("get list of all popular products from main page");
        List<Product> allProducts = new ArrayList<>();
        for (WebElement container : containers) {
            waitUntilVisible(By.xpath("//div[@class='product']"), 5);
            allProducts.add(new Product(container));
        }
        return allProducts;
    }

    public DiscountProductPage clickOnThePricesDropLink() {
        log.info("click on the prices drop link");
        waitUntilClickable(By.id("link-product-page-prices-drop-1"), 5);
        footer.getPricesDropLink().click();
        return new DiscountProductPage();
    }

    public List<String> getAllLanguagesList() {
        waitUntilVisible(By.xpath("//div[@id='_desktop_language_selector']"), 5);
        log.info("get string list of all languages");
        List<String> allLanguagesAsString = new ArrayList<>();

        for (WebElement language : topMenu.getLanguages()) {
            allLanguagesAsString.add(language.getAttribute("text"));
        }
        return allLanguagesAsString;
    }

    public AllProductsPage clickOnTheAllProductsLink() {
        log.info("click on the all products link");
        waitUntilClickable(By.xpath("//a[@class='all-product-link float-xs-left float-md-right h4']"), 3);
        allProductsLink.click();
        return new AllProductsPage();
    }
}
