package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	//Click on BuyNow
	//driver.findElement(By.xpath("//*[text()='Buy Now']")).click();
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	

	//select country
	//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	@FindBy(css = "[placeholder='Select Country']")	
	private WebElement country;
	
	//click on india
	//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	
	@FindBy(css = ".ta-item:nth-of-type(2)")
	private WebElement Selectcountry;
	
	//click on place order
	//driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
	
	@FindBy(xpath = "//*[text()='Place Order ']")
	private WebElement OrderPlace;
	
	By resuts = By.cssSelector(".ta-results");
	
	public void seletCountry(String CountryName) {
		//fill Payment Method
		Actions a = new Actions(driver);
		//select country
		a.sendKeys(country, CountryName).build().perform();
		
		//waitForelementToAppear(resuts);
		Selectcountry.click();
		
		}
	
	public ConfirmationPage submitOrder() {
		OrderPlace.click();
		return new ConfirmationPage(driver);
	}
			
}
