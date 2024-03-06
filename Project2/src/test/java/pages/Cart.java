package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Locators;

public class Cart {
	 @FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")
	    private List<WebElement> productName;

	    @FindBy(xpath = "//td[contains(@class, 'cart_price')]/p")
	    private List<WebElement> price;

	    @FindBy(xpath = "//td[contains(@class, 'cart_quantity')]/button")
	    private List<WebElement> quantity;

	    @FindBy(xpath = "//p[contains(@class, 'cart_total_price')]")
	    private List<WebElement> totalPrice;

	    @FindBy(css = "li[class='active']")
	    private WebElement shoppingCart;

	    @FindBy(css = "a[class='btn btn-default check_out']")
	    private WebElement proceedToCheckoutButton;

	    @FindBy(css = "a[href='/login'] u")
	    private WebElement registerLoginButton;

	    @FindBy(css = "a[data-product-id='1']")
	    private WebElement xButton1;

	    @FindBy(css = "a[data-product-id='2']")
	    private WebElement xButton2;

	    @FindBy(id = "empty_cart")
	    private WebElement emptyCartSpan;

	    @FindBy(css = "a[class='cart_quantity_delete']")
	    private List<WebElement> xButtons;

	    private WebDriver driver;

	    public Cart(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public List<String> getProductsNames() {
	        return productName
	                .stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	    }

	    public List<String> getPrices() {
	        return price
	                .stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	    }

	    public List<String> getQuantity() {
	        return quantity
	                .stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	    }

	    public List<String> getTotalPrices() {
	        return totalPrice
	                .stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	    }

	    public WebElement getShoppingCart() {
	        return shoppingCart;
	    }

	    public Cart proceedToCheckoutButtonClick() {
	        proceedToCheckoutButton.click();
	        return this;
	    }

	    public Checkout proceedToCheckoutLoggedButtonClick() {
	        proceedToCheckoutButton.click();
	        return new Checkout(driver);
	    }

	    public SignUppage registerLoginButtonClick() {
	        registerLoginButton.click();
	        return new SignUppage(driver);
	    }

	    public Cart xButtonClick() {
	        xButton1.click();
	        xButton2.click();
	        return this;
	    }

	    public WebElement getEmptyCartSpan() {
	        Locators.waitForElementToBeVisible(driver, emptyCartSpan);
	        return emptyCartSpan;
	    }

	    public Cart deleteAllAddedProducts() throws InterruptedException {
	        int xButtonsSize = xButtons.size();
	        for (int i = 0; i < xButtonsSize; i++) {
	            xButtons.get(0).click();
	            Thread.sleep(500);
	        }
	            return this;
	    }

}
