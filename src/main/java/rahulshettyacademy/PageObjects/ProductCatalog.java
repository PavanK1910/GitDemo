package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
	WebDriver driver;
	//commom for all POM
	//Create a constructor for "driver"
	//constructor has same class name
	//firstly execute construct then other
	public ProductCatalog(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// Get All Product in List
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//multiple element present so LISt is used	
	//PageFactory 
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	//Get Product List
	public List<WebElement> getProductList() {
		// Wait until product is display
		waitForelementToAppear(productsBy);

		return products;
	}
	
	public WebElement getProductByName(String productName) {
		waitForelementTodisAppear(spinner);
		// Iterate Each product
		WebElement prod = getProductList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
						.findFirst().orElse(null);
		return prod;
	}
	
	//click on add to cart button if prod is match with ZARA COAT 3
	public void addProductTocart(String productName ) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		// Wait until toastmessae is display
		waitForelementToAppear(toastMessage);
		
		//Wait until toaster message is disappear 
		waitForelementTodisAppear(spinner);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
				
	}
	
	
	
	
}
