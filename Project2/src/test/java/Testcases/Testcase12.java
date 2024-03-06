package Testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Cart;
import pages.Homepage;

public class Testcase12 extends TestBase{
	  @Test
	    public void addProductsInCart() {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyBothProductsAreAddedToCart();
	        verifyTheirPricesQuantityAndTotalPrice();
	    }

	   	    private void verifyBothProductsAreAddedToCart() {
	        List<String> productNames = new Homepage(getDriver())
	                .productsButtonClick()
	                .addProductsToCart()
	                .getProductsNames();
	        Assert.assertEquals(productNames.size(), 2, "Verify both products are added to Cart");
	    }

	   	    private void verifyTheirPricesQuantityAndTotalPrice() {
	        List<String> prices = new Cart(getDriver()).getPrices();
	        List<String> quantity = new Cart(getDriver()).getQuantity();
	        List<String> totalPrices = new Cart(getDriver()).getTotalPrices();

	        for (int i = 0; i < 2; i++) {
	            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify their prices and total price");
	            Assert.assertEquals(quantity.get(i), "1", "Verify their quantity");
	            System.out.println(i + ". Prices = Total Prices | " + prices.get(i) + " = " + totalPrices.get(i));
	            System.out.println(i + ". Quantity = 1 | " + quantity.get(i).equals("1"));
	        }
	    }
}
