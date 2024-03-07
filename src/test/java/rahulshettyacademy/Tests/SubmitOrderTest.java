package rahulshettyacademy.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckoutPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.Orderpage;
import rahulshettyacademy.PageObjects.ProductCatalog;
import rahulshettyacademy.TestComponent.Basetest;

public class SubmitOrderTest extends Basetest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// send username and password
		ProductCatalog productCatalog = landingPage.ligonApplication(input.get("email"), input.get("password"));

		// Get Product List
		List<WebElement> products = productCatalog.getProductList();

		// Iterate Each product
		// click on Add to Cart
		productCatalog.addProductTocart(input.get("product"));

		// click on cart
		// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		CartPage cartPage = productCatalog.goToCartPage();

		// verify cart value is correct
		// Iterate each product and check with productName is anyMatch
		// Click on BuyNow
		Boolean match = cartPage.VerifyProducDisplay(input.get("product"));

		// Validate result
		// Assert not handel in POM
		Assert.assertTrue(match);

		CheckoutPage checkoutPage = cartPage.goToCheckOut();
		checkoutPage.seletCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		// validate "Thank you for the order"
		String conFirmMessage = confirmationPage.getconFirmMessage();

		Assert.assertTrue(conFirmMessage.equalsIgnoreCase("Thankyou for the order."));
	}

	// To Verify Zara code 3 is displaying in order page

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistory() {
		ProductCatalog productCatalog = landingPage.ligonApplication("kakdepavan050@gmail.com", "Pavan2!((^");
		Orderpage ordersPage = productCatalog.goToOrders();
		Assert.assertTrue(ordersPage.VerifyProducDisplay(productName));
	}
	
	
	
	//Extends reports 
	
	

	@DataProvider
	public Object[][] getData() throws IOException {
	
		
		List<HashMap<String, String>> data = getJsondataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\rahulshettyacadmy\\data\\PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}

// HasMap

/*
 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
 * "kakdepavan050@gmail.com"); map.put("password", "Pavan2!((^");
 * map.put("productName", "ZARA COAT 3");
 * 
 * HashMap<String, String> map2 = new HashMap<String, String>();
 * map2.put("email", "pranotikakde040@gmail.com"); map2.put("password",
 * "Pavan2!((^"); map2.put("productName", "ADIDAS ORIGINAL");
 */ 