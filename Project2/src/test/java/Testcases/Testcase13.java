package Testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.ProductDetails;

public class Testcase13 extends TestBase {
	  @Test
	    public void verifyProductQuantityInCart() {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyProductDetailIsOpened();
	        verifyThatProductIsDisplayedInCartPageWithExactQuantity();
	    }

	    	    private void verifyProductDetailIsOpened() {
	        new Homepage(getDriver()).viewProduct1ButtonClick();
	        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Product Details", "Verify product detail is opened");
	    }

	   	    private void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
	        List<String> quantity = new ProductDetails(getDriver()).increaseQuantity("4")
	                .addToCartButtonClick()
	                .viewCartButtonClick().getQuantity();
	        Assert.assertEquals(quantity.get(0), "4", "Verify that product is displayed in cart page with exact quantity");
	    }
}
