package com.tutorialsNinja.Pages;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {

	
public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	public LoginPage combiningTwoActionsToNavigateToLoginPage() {
		myAccountDropdown.click();	
		loginOption.click();
		return new LoginPage(driver);		
	}
	
	public RegisterPage combiningTwoActionsToNavigateToRegisterPage() {
		myAccountDropdown.click();	
		registerOption.click();
		return new RegisterPage(driver);		
	}
	
	public void enterProductName(String validProductText) {
		searchBox.sendKeys(validProductText);
	}
	
	public Product clickOnSearchButton() {
		searchButton.click();
		return new Product();
	}
	
	public Product navigateToProductPage(String validProductText) {
		searchBox.sendKeys(validProductText);
		searchButton.click();
		return new Product();
	}
}
