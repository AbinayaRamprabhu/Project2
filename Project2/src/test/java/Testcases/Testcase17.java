package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Cart;

public class Testcase17 extends TestBase {
	  @Test
	    public void removeProductsFromCart() {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        Testcase14.verifyThatCartPageIsDisplayed();
	        verifyThatProductIsRemovedFromTheCart();
	    }

	   	    private void verifyThatProductIsRemovedFromTheCart() {
	        String emptyCartText = new Cart(getDriver())
	                .xButtonClick()
	                .getEmptyCartSpan()
	                .getText();
	        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");
	    }
}
