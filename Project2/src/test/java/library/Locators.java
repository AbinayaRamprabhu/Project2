package library;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {
	  public static void waitForElementToExist(WebDriver driver, By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
	        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }

	    public static void waitForElementToBeVisible(WebDriver driver, WebElement locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
	        wait.until(ExpectedConditions.visibilityOf(locator));
	    }

	    public static void waitForNotToEmptyList(WebDriver driver, By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
	        wait.until(driver1 -> driver.findElements(locator).size() > 0);
	    }

	    @SuppressWarnings("unchecked")
		public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
	        wait.until(ExpectedConditions.refreshed(ElementToBeClickable(element)));
	    }

	    @SuppressWarnings("rawtypes")
		private static ExpectedCondition ElementToBeClickable(WebElement element) {
			// TODO Auto-generated method stub
			return null;
		}

		@SuppressWarnings("unused")
		private static String takeScreenshot(WebDriver driver) throws IOException {
	        int randomNumber =(int) (Math.random() * 1000);
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File file = screenshot.getScreenshotAs(OutputType.FILE);
	        String path = "src/test/resources/screenshots/screenshot" + randomNumber + ".png";
	      FileUtils.copyFile(file, new File(path));
	        return path;
	    }
}
