package rahulshettyaccadmy.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckoutPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.LandingPage;
import rahulshettyacademy.PageObjects.ProductCatalog;
import rahulshettyacademy.TestComponent.Basetest;

public class StepDefinationimpl extends Basetest {

	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommers Page")
	public void Given_I_landed_on_Ecommers_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_In_Username_And_Password(String username, String password) {
		productCatalog = landingPage.ligonApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void When_I_add_product_to_cart(String productName) {
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductTocart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) {
				CartPage cartPage = productCatalog.goToCartPage();
		Boolean match = cartPage.VerifyProducDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOut(); 
		checkoutPage.seletCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
    @Then("{string} message is displayed on confirmationPage")
    public void message_is_displayed_on_confirmationPage(String string) {
    	
    	String conFirmMessage = confirmationPage.getconFirmMessage();
		Assert.assertTrue(conFirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
    }
    
    @Then("{string} message is displayed")
    public void message_is_displayed(String strArg1) {
		Assert.assertEquals(strArg1, landingPage.getErrormessage());
		driver.close();

    }
}
