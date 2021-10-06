package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Getter
public class RegisterAccountPage extends BasePage {

    public RegisterAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement selectMrCheckBox;

    @FindBy(xpath = "//input[@name='id_gender' and @value='2']")
    private WebElement selectMrsCheckBox;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname'] ")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@class='form-control' and @name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdateField;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerDataPrivacyCheckBox;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement agreeToTheTermsAndConditionsCheckBox;

    @FindBy(xpath = "//button[@class='btn btn-primary form-control-submit float-xs-right']")
    private WebElement saveAccountButton;

    @FindBy(xpath = "//li[contains(text(),'Invalid format.')]")
    private WebElement invalidFormatFirstNameMessage;


    public RegisterAccountPage selectMrCheckBox() {
        log.info("select mr check box");
        selectMrCheckBox.click();
        return this;
    }

    public RegisterAccountPage enterFirstName(String firstName) {
        log.info("enter first name");
        firstNameField.sendKeys(firstName);
        return this;
    }

    public RegisterAccountPage enterLastName(String lastName) {
        log.info("enter last name");
        lastNameField.sendKeys(lastName);
        return this;
    }

    public RegisterAccountPage enterEmaile(String email) {
        log.info("enter email");
        emailField.sendKeys(email);
        return this;
    }

    public RegisterAccountPage enterPassword(String password) {
        log.info("enter password");
        passwordField.sendKeys(password);
        return this;
    }

    public RegisterAccountPage enterBirthdate(String birthdate) {
        log.info("enter birthdate");
        birthdateField.sendKeys(birthdate);
        return this;
    }

    public RegisterAccountPage clickCustomerDataPrivacyCheckBox() {
        log.info("click customer data privacy check box");
        customerDataPrivacyCheckBox.click();
        return this;
    }

    public RegisterAccountPage clickAgreeToTheTermsAndConditionsCheckBox() {
        log.info("click agree to the terms and conditions check box");
        agreeToTheTermsAndConditionsCheckBox.click();
        return this;
    }


    public BasePage clickOnSaveAccountButton(Boolean isAccountWasCreated) {
        log.info("click on save account button");
        if (isAccountWasCreated) {
            saveAccountButton.click();
            return new MainPageAfterSignInOrRegister();
        }
        saveAccountButton.click();
        return this;
    }

    public String getInvalidFormatFirstNameMessage() {
        log.info("get invalid format first name message");
        return invalidFormatFirstNameMessage.getText();
    }

    public String getFirstNameFieldBorderColourAfterInvalidDataSet() {
        log.info("get first name field border style after invalid data set");
        return firstNameField.getCssValue("outline");
    }
}
