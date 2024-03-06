package Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;

public class Testcase26 extends TestBase {

    @Test
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality() throws InterruptedException {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        Testcase25.verifySubscriptionIsVisible();
        verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen();
    }

       private void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new Homepage(getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers());
        boolean fullFledgedTextIsDisplayed = new Homepage(getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers().isDisplayed();
        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        double value = (double) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(value < 400, "Verify that page is scrolled up");
    }
}
