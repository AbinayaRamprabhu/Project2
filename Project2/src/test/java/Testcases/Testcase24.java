package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.Excelutility;
import library.Utilities;
import pages.Payment;

public class Testcase24 extends TestBase{
	  String name = "name" + Utilities.generateCurrentDateAndTime();
	    String email = "email" + Utilities.generateCurrentDateAndTime() + "@o2.pl";

	    @Test
	    public void downloadInvoiceAfterPurchaseOrder() throws IOException, ParseException, java.text.ParseException {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        Testcase14.verifyThatCartPageIsDisplayed();
	        Testcase14.verifyAccountCreatedAndClickContinueButton(name, email);
	        Testcase14.verifyLoggedInAsUsernameAtTop(name);
	        Testcase14.verifyAddressDetailsAndReviewYourOrder();
	        Testcase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully();
	        new Payment(getDriver()).continueButtonClick();
	        Testcase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }

	  	    private void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() throws IOException {
	        new Payment(getDriver()).downloadInvoiceButtonClick();
	        boolean isFileDownloaded = Excelutility.isFileDownloaded("invoice", "txt", 5000);
	        Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");
	    }
}
