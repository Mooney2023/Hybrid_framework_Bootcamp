package com.tutorialsNinja.TestCases;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.ProductPage;

import dev.failsafe.internal.util.Assert;

public class SearchProductTest {

	public SearchProductTest() throws Exception {
		super();
	}
	
public WebDriver driver;
public HomePage homepage;
public Product productpage;
	
	@BeforeMethod
	public void loginSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
	}
	
	@Test(priority=1)
	public void verifySearchValidProduct() {
		homepage = new HomePage(driver);
		Object dataProp;
		productpage = homepage.navigateToProductPage(((Object) dataProp).getProperty("validProduct"));
        Assert.assertTrue(ProductPage)productpage).verifyValidProductPresence());
	}
	
	@Test(priority=2)
	public void verifySearchInvalidProduct() {
		homepage = new HomePage(driver);
		productpage = homepage.navigateToProductPage(dataProp.getProperty("invalidProduct"));
		Assert.assertFalse(ProductPage)productpage).verifyInvalidProductWarningMessageDisplay());
	}
	
	
	@Test(priority=3)
	public void verifySearchNoProduct() {
		homepage = new HomePage(driver);
		productpage = homepage.clickOnSearchButton();
		Assert.assertTrue(productpage).verifyInvalidProductWarningMessageDisplay());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
