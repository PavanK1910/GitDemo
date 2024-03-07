package rahulshettyacademy.Abstractcomponent;
//this is parent class use in all child

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.Orderpage;

public class AbstractComponent {
	
	//Enable Driver
	
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}

	//PageFactory
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public Orderpage goToOrders() {
		orderHeader.click();
		Orderpage orderPage = new Orderpage(driver);
		return orderPage;
		
	}
	
	public void waitForelementToAppear(By findBy) {
		// Explicit Wait

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
		// Wait until product is display
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebelementToAppear(WebElement findBy) {
		// Explicit Wait

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
		// Wait until product is display
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void waitForelementTodisAppear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	public CartPage goToCartPage() {
		//click on cart
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
}
