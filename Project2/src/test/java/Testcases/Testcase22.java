package Testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;

public class Testcase22 extends TestBase{
	 @Test
	    public void AddToCartFromRecommendedItems() {
	        verifyRecommendedItemsAreVisible();
	        verifyThatProductIsDisplayedInCartPage();
	    }

	    
	    private void verifyRecommendedItemsAreVisible() {
	        String recommendedItemsText = new Homepage(getDriver())
	                .getRecommendedItems()
	                .getText();
	        Assert.assertEquals(recommendedItemsText, "RECOMMENDED ITEMS", "Verify 'RECOMMENDED ITEMS' are visible");
	    }

	   	    private void verifyThatProductIsDisplayedInCartPage() {
	        List<String> productsNames = new Homepage(getDriver())
	                .blueTopAddToCartButtonClick()
	                .viewCartButtonClick()
	                .getProductsNames();
	        Assert.assertEquals(productsNames.get(0), "Blue Top", "Verify that product is displayed in cart page");
	    }
}
