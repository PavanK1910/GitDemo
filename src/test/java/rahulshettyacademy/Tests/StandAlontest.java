package rahulshettyacademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.PageObjects.LandingPage;

public class StandAlontest {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// maximaize window
		driver.manage().window().maximize();
		
		// wait 10 second global
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// launch URL
		driver.get("https://rahulshettyacademy.com/client");
				
		// UserName
		driver.findElement(By.id("userEmail")).sendKeys("kakdepavan050@gmail.com");

		// Password
		driver.findElement(By.id("userPassword")).sendKeys("Pavan2!((^");

		// Click on login button
		driver.findElement(By.id("login")).click();
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		//Wait until product is display
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		// Get All Product in List
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		// Iterate Each product
		WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
				.findFirst().orElse(null);
		
		//click on Add to Cart 
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//wait until loading is invisible
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//Wait until toaster message is disappear 
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//click on cart
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//verify cart value is correct 
		List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
		
		//Iterate each product and check with productName is anyMatch
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		
		
		//Validate result
		Assert.assertTrue(match);
		
		//Click on BuyNow
		driver.findElement(By.xpath("//*[text()='Buy Now']")).click();
		
		//fill Payment Method
		Actions a = new Actions(driver);
		//select country
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		
		//click on india
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		

		//click on place order
		driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
		
		//validate "Thank you for the order"
		String conFirmMessage =  driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(conFirmMessage.equalsIgnoreCase("Thankyou for the order."));
		//Closed the Driver
		driver.close();
		
	}

}
