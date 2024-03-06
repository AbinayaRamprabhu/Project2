package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import pages.Homepage;

public class Testcase11 extends TestBase{
    @Test
    public void verifySubscriptionInCartPage() throws IOException, ParseException {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        new Homepage(getDriver()).cartButtonClick();
        Testcase10.verifyTextSubscription();
        Testcase10.verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
    }
}
