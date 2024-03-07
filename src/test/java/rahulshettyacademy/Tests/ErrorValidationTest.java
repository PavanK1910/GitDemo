package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckoutPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.ProductCatalog;
import rahulshettyacademy.TestComponent.Basetest;
import rahulshettyacademy.TestComponent.Retry;

public class ErrorValidationTest extends Basetest{

	
		
		
		
	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
		
		public void LoginErrorValidation() throws IOException, InterruptedException {
				
			
			
			
			
		//send username and password 
		landingPage.ligonApplication("kakdepavan05@gmail.com", "Pavan2!((^");
		
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrormessage());
		
		
	}
		
		@Test
		public void productErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		
		
		//send username and password 
		ProductCatalog productCatalog = landingPage.ligonApplication("kakdepavan050@gmail.com", "Pavan2!((^");
		
		//Get Product List
		List<WebElement>products =productCatalog.getProductList();
						
		// Iterate Each product
		//click on Add to Cart 
		productCatalog.addProductTocart(productName);
		
				
		//click on cart
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		CartPage cartPage =productCatalog.goToCartPage();
		
		
		
		//verify cart value is correct 
		//Iterate each product and check with productName is anyMatch
		//Click on BuyNow
		Boolean match = cartPage.VerifyProducDisplay("ZARA COAT 33");
		
				
		//Validate result
		//Assert not handel in POM
		Assert.assertFalse(match);
		
		
		
	}


}
