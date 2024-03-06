package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetails;
import pages.Products;

public class Testcase21 extends TestBase{
	 @Test
	    public void addReviewOnProduct() throws IOException, ParseException {
	        Testcase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        verifyWriteYourReviewIsVisible();
	        verifySuccessMessageThankYouForYourReview();
	    }

	   	    private void verifyWriteYourReviewIsVisible() {
	        String writeYourReviewText = new Products(getDriver())
	                .viewProductOfFirstProductButtonClick()
	                .getWriteYourReview()
	                .getText();
	        Assert.assertEquals(writeYourReviewText, "WRITE YOUR REVIEW", "Verify 'Write Your Review' is visible");
	    }

	  	    private void verifySuccessMessageThankYouForYourReview() throws IOException, ParseException {
	        String successMessageText = new ProductDetails(getDriver()).fillReview().getSuccessMessage().getText();
	        Assert.assertEquals(successMessageText, "Thank you for your review.", "Verify success message 'Thank you for your review.'");
	    }
}
