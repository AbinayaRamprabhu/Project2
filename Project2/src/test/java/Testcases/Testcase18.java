package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Products;

public class Testcase18 extends TestBase{
	@Test
    public void viewCategoryProducts() {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyThatCategoriesAreVisibleOnLeftSideBar();
        verifyThatCategoryPageIsDisplayedAndConfirmTextWomenDressProducts();
        verifyThatUserIsNavigatedToThatCategoryPage();
    }

       private void verifyThatCategoriesAreVisibleOnLeftSideBar() {
        boolean categoriesAreVisible = new Homepage(getDriver())
                .getCategories()
                .isDisplayed();
        Assert.assertTrue(categoriesAreVisible, "Verify that categories are visible on left side bar");
    }

       private void verifyThatCategoryPageIsDisplayedAndConfirmTextWomenDressProducts() {
        String titleTextCenter = new Homepage(getDriver())
                .womenCategoryClick()
                .dressCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "WOMEN - DRESS PRODUCTS", "Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");
    }

       private void verifyThatUserIsNavigatedToThatCategoryPage() {
        String titleTextCenter = new Products(getDriver())
                .menCategoryClick()
                .tShirtsCategoryClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "MEN - TSHIRTS PRODUCTS", "Verify that user is navigated to that category page");
    }
}
