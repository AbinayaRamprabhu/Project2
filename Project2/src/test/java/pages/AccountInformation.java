package pages;

import Testcases.TestBase;
import library.Utilities;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AccountInformation extends TestBase{
	  @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
	    private WebElement enterAccountInformation;

	    @FindBy(id = "id_gender1")
	    private WebElement titleMrCheckbox;

	    @FindBy(id = "password")
	    private WebElement passwordInput;

	    @FindBy(id = "days")
	    private WebElement daysSelect;

	    @FindBy(id = "months")
	    private WebElement monthsSelect;

	    @FindBy(id = "years")
	    private WebElement yearsSelect;

	    @FindBy(id = "newsletter")
	    private WebElement newsletterCheckbox;

	    @FindBy(id = "optin")
	    private WebElement specialOffersCheckbox;

	    @FindBy(id = "first_name")
	    private WebElement firstNameInput;

	    @FindBy(id = "last_name")
	    private WebElement lastNameInput;

	    @FindBy(id = "company")
	    private WebElement companyInput;

	    @FindBy(id = "address1")
	    private WebElement address1Input;

	    @FindBy(id = "address2")
	    private WebElement address2Input;

	    @FindBy(id = "country")
	    private WebElement countrySelect;

	    @FindBy(id = "state")
	    private WebElement stateInput;

	    @FindBy(id = "city")
	    private WebElement cityInput;

	    @FindBy(id = "zipcode")
	    private WebElement zipcodeInput;

	    @FindBy(id = "mobile_number")
	    private WebElement mobileNumberInput;

	    @FindBy(css = "button[data-qa='create-account']")
	    private WebElement createAccountButton;

	    private WebDriver driver;

	    public AccountInformation(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getEnterAccountInformation() {
	        return enterAccountInformation;
	    }

	    public AccountCreation fillAccountDetails() throws IOException, java.text.ParseException, ParseException{
	        String password = "pass" + Utilities.generateCurrentDateAndTime();
	        titleMrCheckbox.click();
	        passwordInput.sendKeys(password);
	        Select days = new Select(daysSelect);
	        days.selectByValue(library.JSONReader.accountDetails("day"));
	        Select months = new Select(monthsSelect);
	        months.selectByValue(library.JSONReader.accountDetails("month"));
	        Select years = new Select(yearsSelect);
	        years.selectByValue(library.JSONReader.accountDetails("year"));
	        newsletterCheckbox.click();
	        specialOffersCheckbox.click();
	        firstNameInput.sendKeys(library.JSONReader.accountDetails("firstName"));
	        lastNameInput.sendKeys(library.JSONReader.accountDetails("lastName"));
	        companyInput.sendKeys(library.JSONReader.accountDetails("company"));
	        address1Input.sendKeys(library.JSONReader.accountDetails("address1"));
	        address2Input.sendKeys(library.JSONReader.accountDetails("address2"));
	        Select countrySelector = new Select(countrySelect);
	        countrySelector.selectByValue(library.JSONReader.accountDetails("country"));
	        stateInput.sendKeys(library.JSONReader.accountDetails("state"));
	        cityInput.sendKeys(library.JSONReader.accountDetails("city"));
	        zipcodeInput.sendKeys(library.JSONReader.accountDetails("zipcode"));
	        mobileNumberInput.sendKeys(library.JSONReader.accountDetails("mobileNumber"));
	        createAccountButton.click();
	        return new AccountCreation(driver);
	    }
}
