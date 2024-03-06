package library;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class InvokeBrowser {
	 public static WebDriver doBrowserSetup() throws IOException {
	        WebDriver driver = null;
	        String name = Config.loadProperty("browser.name");
	        if (name.equalsIgnoreCase("Chrome")) {

	            String pathExtension = Config.loadProperty("chrome.extension.adblock.path");

	            System.setProperty("webdriver.chrome.silentOutput", "true");
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("load-extension=" + pathExtension); //uBlock Origin
	            chromeOptions.addArguments("--headless");
	            driver = new ChromeDriver(chromeOptions);

	        } else if (name.equalsIgnoreCase("Firefox")) {
	            FirefoxOptions firefoxOptions = new FirefoxOptions();
	            firefoxOptions.addArguments("--headless");
	            firefoxOptions.addArguments("--private");
	            driver = new FirefoxDriver(firefoxOptions);
	        }
	        return driver;
	    }
}
