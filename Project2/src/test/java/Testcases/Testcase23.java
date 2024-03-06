package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import library.Utilities;

public class Testcase23 extends TestBase{

    String name = "name" + Utilities.generateCurrentDateAndTime();
    String email = "email" + Utilities.generateCurrentDateAndTime() + "@o2.pl";

    @Test
    public void verifyAddressDetailsInCheckoutPage() throws IOException, ParseException, java.text.ParseException {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        Testcase14.verifyAccountCreatedAndClickContinueButton(name, email);
        Testcase14.verifyLoggedInAsUsernameAtTop(name);
        Testcase14.verifyThatCartPageIsDisplayed();
        verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount();
        Testcase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

   
    private void verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() throws IOException, ParseException {
        Testcase14.verifyAddressDetails();
    }
}
