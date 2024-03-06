package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletion {
	  @FindBy(css = "h2[data-qa='account-deleted']")
	    private WebElement accountDeleted;

	    @FindBy(css = "a[data-qa='continue-button']")
	    private WebElement continueButton;

	    private WebDriver driver;

	    public AccountDeletion(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getAccountDeleted() {
	        return accountDeleted;
	    }

	    public Homepage continueButtonClick() {
	        continueButton.click();
	        return new Homepage(driver);
	    }

}
