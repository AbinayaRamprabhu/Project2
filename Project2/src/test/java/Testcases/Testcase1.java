package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.Utilities;
import pages.AccountCreation;
import pages.AccountDeletion;
import pages.AccountInformation;
import pages.Homepage;
import pages.SignUppage;

public class Testcase1 extends TestBase{
	 String name = "name" + Utilities.generateCurrentDateAndTime();
	    String email = "email" + Utilities.generateCurrentDateAndTime() + "@o2.pl";

	    @Test
	    public void registerUser() throws IOException, ParseException, java.text.ParseException {
	        verifyThatHomePageIsVisibleSuccessfully();
	        verifyNewUserSignupIsVisible();
	        verifyThatEnterAccountInformationIsVisible();
	        verifyThatAccountCreatedIsVisible();
	        verifyThatLoggedInAsUsernameIsVisible();
	        verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }

	    	    public static void verifyThatHomePageIsVisibleSuccessfully() {
	        boolean homePageVisible = new Homepage(getDriver())
	                .homePageIsVisible()
	                .isDisplayed();
	        Assert.assertTrue(homePageVisible, "Verify that home page is visible successfully");
	    }

	   	    public static void verifyNewUserSignupIsVisible() {
	        String newUserSignupText = new Homepage(getDriver())
	                .signupLoginClick()
	                .getNewUserSignup()
	                .getText();
	        Assert.assertEquals(newUserSignupText, "New User Signup!", "Verify 'New User Signup!' is visible");
	    }

	   	    private void verifyThatEnterAccountInformationIsVisible() {
	        String enterAccountInformationText = new SignUppage(getDriver())
	                .fillCorrectSignup(name, email)
	                .getEnterAccountInformation()
	                .getText();
	        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
	    }

	   	    private void verifyThatAccountCreatedIsVisible() throws IOException, ParseException, java.text.ParseException {
	        String accountCreatedText = new AccountInformation(getDriver()).fillAccountDetails().getAccountCreated().getText();
	        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify that 'ACCOUNT CREATED!' is visible");
	    }

	    	    private void verifyThatLoggedInAsUsernameIsVisible() {
	        String username = new AccountCreation(getDriver())
	                .continueButtonClick()
	                .getUsername()
	                .getText();
	        Assert.assertEquals(username, name, "Verify that 'Logged in as username' is visible");
	    }

	   	    public static void verifyThatAccountDeletedIsVisibleAndClickContinueButton() {
	        String accountDeletedText =  ((AccountDeletion) new Homepage(getDriver()).deleteAccountButtonClick()).getAccountDeleted().getText();
	        Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");
	        new AccountDeletion(getDriver()).continueButtonClick();
	    }
}
