package Testcases;

import java.io.IOException;
import java.util.List;

import javax.annotation.Nonnull;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.JSONReader;
import pages.Cart;
import pages.Homepage;
import pages.Products;

public class Testcase20 extends TestBase {

    @Test
    public void searchProductsAndVerifyCartAfterLogin() throws IOException, ParseException, InterruptedException {
        Testcase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        Testcase9.verifySearchedProductsIsVisible();
        List<String> productsNames = Testcase9.verifyAllTheProductsRelatedToSearchAreVisible();
        new Products(getDriver()).addAllProducts();
        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
        new Homepage(getDriver()).signupLoginClick().fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
        verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(productsNames);
        verifyThatCartIsEmpty();
    }

        private void clickCartButtonAndVerifyThatProductsAreVisibleInCart(@Nonnull List<String> productsNames) {
        List<String> productsNamesAdded = new Homepage(getDriver())
                .cartButtonClick()
                .getProductsNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), productsNamesAdded.get(i), "Verify that products are visible in cart");
            System.out.println("Search: " + productsNames.get(i) + " = Added: " + productsNamesAdded.get(i));
        }
    }

        private void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(@Nonnull List<String> productsNames) {
        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
    }

        private void verifyThatCartIsEmpty() throws InterruptedException {
        String emptyCartText = new Cart(getDriver())
                .deleteAllAddedProducts()
                .getEmptyCartSpan()
                .getText();
        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify 'Cart is empty! Click here to buy products.' is visible");
    }
}
