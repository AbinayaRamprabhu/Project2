package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.JSONReader;
import pages.Cart;
import pages.Homepage;
import pages.LoggedHomepage;

public class Testcase16 extends TestBase{

    @Test
    public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        new Homepage(getDriver()).signupLoginClick().fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
        verifyLoggedInAsUsernameAtTop();
        Testcase14.verifyThatCartPageIsDisplayed();
        new Cart(getDriver()).proceedToCheckoutButtonClick();
        Testcase14.verifyAddressDetailsAndReviewYourOrder();
        Testcase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
    }

    private void verifyLoggedInAsUsernameAtTop() throws IOException, ParseException {
        String username = new LoggedHomepage(getDriver())
                .getUsername()
                .getText();
        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify 'Logged in as username' at top");
    }
}
