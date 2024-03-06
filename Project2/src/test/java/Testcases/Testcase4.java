package Testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoggedHomepage;

public class Testcase4 extends TestBase{

    @Test
    public void logoutUser() throws IOException, ParseException {
        Testcase2.loginUserWithCorrectEmailAndPassword();
        verifyThatUserIsNavigatedToLoginPage();
    }

      private void verifyThatUserIsNavigatedToLoginPage() {
        String loginToYourAccountText = new LoggedHomepage(getDriver())
                .logoutButtonClick()
                .getLoginToYourAccount()
                .getText();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
    }
}
