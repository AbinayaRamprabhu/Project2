package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import library.Config;
import library.InvokeBrowser;

public class TestBase {
	 protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	    public static synchronized WebDriver getDriver() {
	        return tdriver.get();
	    }

	    @BeforeMethod
	    public void setup() throws IOException {
	        String url = Config.loadProperty("url");
	        WebDriver driver = InvokeBrowser.doBrowserSetup();
	        tdriver.set(driver);
	        getDriver().get(url);
	    }

	    @AfterMethod
	    public void tearDown() {
	        getDriver().quit();
	        tdriver.remove();
	    }
}
