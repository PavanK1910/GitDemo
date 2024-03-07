package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class Orderpage extends AbstractComponent{
	
	WebDriver driver;
	//commom for all POM
	//Create a constructor for "driver"
	//constructor has same class name
	//firstly execute construct then other
	public Orderpage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/*
	 * //verify cart value is correct 
		List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
		
		//Iterate each product and check with productName is anyMatch
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		
		
		//Validate result
		Assert.assertTrue(match);
		
	 */
	//PageFactory 
	
	@FindBy(xpath="//*[text()='Buy Now']")
	WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> producName;
	
	
	public Boolean VerifyProducDisplay(String productName) {
		Boolean match = producName.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
	
	public   CheckoutPage goToCheckOut() {
		checkoutEle.click();
		return new CheckoutPage(driver);
		
	}
	
	
	
	
	
	
}
