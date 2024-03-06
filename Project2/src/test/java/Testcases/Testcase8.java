package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.ProductDetails;
import pages.Products;

public class Testcase8 extends TestBase {
	 @Test
	    public void verifyAllProductsAndProductDetailPage() {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        new Products(getDriver()).viewProductOfFirstProductButtonClick();
	        verifyThatDetailDetailIsVisible();
	    }

	   	    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
	        String allProductsText = new Homepage(getDriver()).productsButtonClick().getTitleTextCenter().getText();
	        Assert.assertEquals(allProductsText, "ALL PRODUCTS", "Verify user is navigated to ALL PRODUCTS page successfully");
	    }

	        private void verifyThatDetailDetailIsVisible() {
	        boolean name = new ProductDetails(getDriver()).getProductName().isDisplayed();
	        boolean category = new ProductDetails(getDriver()).getProductCategory().isDisplayed();
	        boolean price = new ProductDetails(getDriver()).getProductPrice().isDisplayed();
	        boolean availability = new ProductDetails(getDriver()).getProductAvailability().isDisplayed();
	        boolean condition = new ProductDetails(getDriver()).getProductCondition().isDisplayed();
	        boolean brand = new ProductDetails(getDriver()).getProductBrand().isDisplayed();

	        Assert.assertTrue(name, "Verify that detail detail is visible: name");
	        Assert.assertTrue(category, "Verify that detail detail is visible: category");
	        Assert.assertTrue(price, "Verify that detail detail is visible: price");
	        Assert.assertTrue(availability, "Verify that detail detail is visible: availability");
	        Assert.assertTrue(condition, "Verify that detail detail is visible: condition");
	        Assert.assertTrue(brand, "Verify that detail detail is visible: brand");
	    }
}
