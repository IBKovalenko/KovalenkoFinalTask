package components;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


@Getter
public class TopMenu {

    public TopMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-iso-code]")
    private List<WebElement> languages;


    @FindBy(xpath = ".//span[contains(text(),'Sign in')]")
    private WebElement signInButton;
}
