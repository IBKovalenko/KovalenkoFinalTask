package components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class Footer {

    public Footer(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "link-product-page-prices-drop-1")
    private WebElement pricesDropLink;
}
