package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Product {

    @FindBy(xpath = ".//div[@class='product']")
    private List<WebElement> containers;

    private WebElement name;
    private String nameAsString;
    private WebElement image;
    private WebElement price;
    private double priceAsDouble;
    private WebElement oldPrice;
    private double oldPriceAsDouble;
    private WebElement discount;
    private double discountValue;

    public Product(WebElement container) {

        if (container.findElements(By.xpath(".//h2[@itemprop='name']")).size() > 0) {
            this.name = container.findElement(By.xpath(".//h2[@itemprop='name']"));
        } else {
            this.name = container.findElement(By.xpath(".//h3[@itemprop='name']"));
        }
        this.nameAsString = name.getText();
        this.image = container.findElement(By.xpath(".//div[@class='thumbnail-container reviews-loaded']//img"));
        if (container.findElements(By.xpath(".//span[@class='regular-price']")).size() > 0) {
            this.oldPrice = container.findElement(By.xpath(".//span[@class='regular-price']"));
            this.oldPriceAsDouble = Double.parseDouble(oldPrice.getText().replace("€", ""));
        } else {
            this.oldPrice = null;
        }
        this.price = container.findElement(By.xpath(".//span[@class='price']"));
        this.priceAsDouble = Double.parseDouble(price.getText().replace("€", ""));
        if (container.findElements(By.xpath(".//li[@class='product-flag discount']")).size() == 0) {
            discountValue = 0;

        } else {
            this.discount = container.findElement(By.xpath(".//li[@class='product-flag discount']"));
            this.discountValue = Double.parseDouble(discount.getText().replace("%", "").replace("-", ""));
        }
    }
}
