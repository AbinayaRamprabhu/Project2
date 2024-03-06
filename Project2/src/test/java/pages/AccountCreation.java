package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation {
	 @FindBy(css = "h2[data-qa='account-created']")
	    private WebElement accountCreated;

	    @FindBy(css = "a[data-qa='continue-button']")
	    private WebElement continueButton;

	    private WebDriver driver;

	    public AccountCreation(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getAccountCreated() {
	        return accountCreated;
	    }

	    public LoggedHomepage continueButtonClick() {
	        continueButton.click();
	        return new LoggedHomepage(driver);
	    }
	}

