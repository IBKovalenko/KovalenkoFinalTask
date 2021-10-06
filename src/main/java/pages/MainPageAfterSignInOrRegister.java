package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class MainPageAfterSignInOrRegister extends BasePage {

    public MainPageAfterSignInOrRegister() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='account']/child::span")
    private WebElement firstNameAndLastNameAppears;

    public String getFirstNameAndLastNameAppears() {
        log.info("get first name and last name appears in left side of page");
        return firstNameAndLastNameAppears.getText();
    }
}
