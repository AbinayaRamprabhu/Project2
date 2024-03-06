package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;

public class Testcase7 extends TestBase{
	  @Test
	    public void verifyTestCasesPage() {
	        Testcase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToTestCasesPageSuccessfully();
	    }

	   	    private void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
	        String testCasesText = new Homepage(getDriver())
	                .testCasesButtonClick()
	                .getTestCases()
	                .getText();
	        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");
	    }
}
