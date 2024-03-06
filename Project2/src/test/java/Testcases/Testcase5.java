package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SignUppage;

public class Testcase5 extends TestBase{

    @Test
    public void registerUserWithExistingEmail() throws IOException, ParseException {
        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
        Testcase1.verifyNewUserSignupIsVisible();
        verifyErrorEmailAddressAlreadyExistIsVisible();
    }

       private void verifyErrorEmailAddressAlreadyExistIsVisible() throws IOException, ParseException {
        String emailAddressAlreadyExistText = new SignUppage(getDriver()).fillIncorrectSignup().getEmailAddressAlreadyExist().getText();
        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "Verify error 'Email Address already exist!' is visible");
    }
}
