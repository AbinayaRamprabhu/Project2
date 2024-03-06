package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.JSONReader;
import pages.Homepage;
import pages.SignUppage;

public class Testcase2 extends TestBase{
	 @Test
	    public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyLoginToYourAccountIsVisible();
	        verifyThatLoggedInAsUsernameIsVisible();
	    }

	   	    public static void verifyLoginToYourAccountIsVisible() {
	        String loginToYourAccountText = new Homepage(getDriver())
	                .signupLoginClick()
	                .getLoginToYourAccount()
	                .getText();
	        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify 'Login to your account' is visible");
	    }

	   	    private static void verifyThatLoggedInAsUsernameIsVisible() throws IOException, ParseException {
	        Homepage username = new SignUppage(getDriver()).fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
	        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify that 'Logged in as username' is visible");
	    }
}
