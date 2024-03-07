package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	//validate "Thank you for the order"
	//String conFirmMessage =  driver.findElement(By.cssSelector(".hero-primary")).getText();
	@FindBy(css = ".hero-primary")
	WebElement conFirmMessage;
	
	public String getconFirmMessage() {
		return conFirmMessage.getText();
	}
}
