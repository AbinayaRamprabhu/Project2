package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import library.Utilities;
import pages.SignUppage;

public class Testcase3 extends TestBase {
	   @Test
	    public void loginUserWithIncorrectEmailAndPassword() {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        Testcase2.verifyLoginToYourAccountIsVisible();
	        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();
	    }

	   	    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
	        String email = "email" + Utilities.generateCurrentDateAndTime() + "@incorrect.pl";
	        String password = "pass" + Utilities.generateCurrentDateAndTime();

	        String errorLoginText = new SignUppage(getDriver())
	                .fillIncorrectLogin(email, password)
	                .getErrorLogin()
	                .getText();
	        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "Verify error 'Your email or password is incorrect!' is visible");
	    }
}
