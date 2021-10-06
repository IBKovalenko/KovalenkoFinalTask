package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Slf4j
public class LoginPage extends BasePage{

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-link-action]")
    private WebElement createAccountLink;

    public RegisterAccountPage clickOnTheCreateAccountLink(){
        log.info("click on the create account link");
        waitUntilClickable(By.xpath("//a[@data-link-action]"),3);
        createAccountLink.click();
        return new RegisterAccountPage();
    }
}
