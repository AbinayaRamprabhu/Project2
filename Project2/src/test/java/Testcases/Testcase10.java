package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;

public class Testcase10 extends TestBase {

    @Test
    public void verifySubscriptionInHomePage() throws IOException, ParseException {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyTextSubscription();
        verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
    }

      public static void verifyTextSubscription() {
        String subscriptionText = new Homepage(getDriver())
                .getSubscription()
                .getText();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");
    }

        public static void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() throws IOException, ParseException {
        String messageAlert = new Homepage(getDriver()).fillSubscribe().getAlertSuccessSubscribe().getText();
        Assert.assertEquals(messageAlert, "You have been successfully subscribed!", "Verify success message 'You have been successfully subscribed!' is visible");
    }
}
