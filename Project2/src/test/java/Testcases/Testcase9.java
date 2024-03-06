package Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.Config;
import pages.Products;

public class Testcase9 {

    static String search;

    static {
        try {
            search = Config.loadProperty("search.product.input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void searchProduct() {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        Testcase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        verifySearchedProductsIsVisible();
        verifyAllTheProductsRelatedToSearchAreVisible();
    }

        public static void verifySearchedProductsIsVisible() {
        String searchedProductsText = new Products(getDriver()).fillSearchProductInput(search).getTitleTextCenter().getText();
        Assert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS", "Verify 'SEARCHED PRODUCTS' is visible");
    }

       private static WebDriver getDriver() {
			
			return null;
		}

	public static List<String> verifyAllTheProductsRelatedToSearchAreVisible() {
        List<String> productsNames = new Products(getDriver()).getProductsSearchNames();

        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
            System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
        }
        return productsNames;
    }
}
