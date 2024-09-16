package com.tutorialsNinja.TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.AddToCartPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.ProductPage;

public class CheckoutTest {

	
	public CheckoutTest() throws Exception {
		super();
	}
	
	public WebDriver driver;
	public HomePage homepage;
	public ProductPage productpage;
	public AddToCartPage addtocartpage;

	
	@BeforeMethod
	public void completeCheckOutSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		Product = homepage.navigateToProductPage(dataProp.getProperty("validProduct"));
	}
	
	@Test(priority=1)
	public void validatingValidProduct() {
		Assert.assertTrue(Product.verifyValidProductPresence());	
	}
	
	
	@Test(priority=2)
	public void validateCompleteCheckoutWithValidProductPositiveFlow(){
		addtocartpage = Product.clickOnAddToCartButton();
		Assert.assertTrue(addtocartpage.displayStatusOfLaptopPrice());
		driver.findElement(By.id("button-cart")).click();
		
		String actualSuccessMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		String expectedSuccessMessage = "Success: You have added ";
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));
		
		Assert.assertTrue(driver.findElement(By.xpath(" //span[@id = 'cart-total'][text() = ' 1 item(s) - $122.00']")).isDisplayed());
		driver.findElement(By.id("cart")).click();

	}



	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
