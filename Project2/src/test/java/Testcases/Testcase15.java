package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import library.Utilities;
import pages.Cart;

public class Testcase15 extends TestBase{
	  String name = "name" + Utilities.generateCurrentDateAndTime();
	    String email = "email" + Utilities.generateCurrentDateAndTime() + "@o2.pl";

	    @Test
	    public  void Checkout() throws IOException, ParseException {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        Testcase14.verifyAccountCreationAndClickContinueButton(name, email);
	        Testcase14.verifyLoggedInAsUsernameAtTop(name);
	        Testcase14.verifyThatCartPageIsDisplayed();
	        new Cart(getDriver()).proceedToCheckoutButtonClick();
	        Testcase14.verifyAddressDetailsAndReviewYourOrder();
	        Testcase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        Testcase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }
}
