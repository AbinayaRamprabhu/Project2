package Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;

public class Testcase25  extends TestBase{

    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality() throws InterruptedException {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        verifySubscriptionIsVisible();
        verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen();
    }

       public static void verifySubscriptionIsVisible() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new Homepage(getDriver()).getSubscription());
        boolean subscriptionIsDisplayed = new Homepage(getDriver()).getSubscription().isDisplayed();
        Assert.assertTrue(subscriptionIsDisplayed, "Verify 'SUBSCRIPTION' is visible");
    }

      private void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        boolean fullFledgedTextIsDisplayed = new Homepage(getDriver())
                .scrollUpButtonClick()
                .getFullFledgedPracticeWebsiteForAutomationEngineers()
                .isDisplayed();
        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        double value = (double) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(value < 2500, "Verify that page is scrolled up");
        System.out.println(value);
    }
}
