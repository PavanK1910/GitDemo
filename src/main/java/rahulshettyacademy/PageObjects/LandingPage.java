package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	// Create a constructor for "driver"
	// constructor has same class name
	// firstly execute construct then other
	public LandingPage(WebDriver driver) {

		// Send driver child to parent
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// PageFactory
	@FindBy(id = "userEmail")
	WebElement userEmail;

	// driver.findElement(By.id("userPassword"))
	@FindBy(id = "userPassword")
	WebElement userPass;

	// driver.findElement(By.id("login"))
	@FindBy(id = "login")
	WebElement loginButton;
	// .ng-tns-c4-3.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error

	// errorvalidation
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	// Action in pagefactory
	public ProductCatalog ligonApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPass.sendKeys(password);
		loginButton.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}

	// goto login page
	public void goTo() {
		// launch URL

		driver.get("https://rahulshettyacademy.com/client");

		
	}

	public String getErrormessage() {
		waitForWebelementToAppear(errorMessage);
		return errorMessage.getText();
	}

}
