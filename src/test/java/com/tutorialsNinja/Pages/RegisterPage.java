package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstnameTextBox;

	@FindBy(id = "input-lastname")
	private WebElement lastnameTextBox;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//input[@name = 'newsletter' and @value='1']")
	private WebElement subscribeNewsLetterYesRadioButton;
	
	@FindBy(css = "a.agree+input")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(css = "input#input-firstname+div")
	private WebElement firstnameWarningMessage;
	
	@FindBy(css = "input#input-lastname+div")
	private WebElement lastnameWarningMessage;
	
	@FindBy(css = "input#input-email+div")
	private WebElement emailWarningMessage;
	
	@FindBy(css = "input#input-telephone+div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(css = "input#input-password+div")
	private WebElement passwordWarningMessage;
	
	@FindBy(css = "input#input-confirm + div")
	private WebElement wrongConfirmPasswordWarningMessage;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstnameText) {
		firstnameTextBox.sendKeys(firstnameText);
	}
	
	public void enterLastName(String lastnameText) {
		lastnameTextBox.sendKeys(lastnameText);
	}
	
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmpasswordText) {
		confirmPasswordTextBox.sendKeys(confirmpasswordText);
	}
	
	public void clickOnNewsLetterRadioButton() {
		subscribeNewsLetterYesRadioButton.click();
	}
	
	public void checkPrivacyPolicyCheckBox() {
		privacyPolicyCheckBox.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public String retrievePrivacyPolicyWarningMessage() {
		String text = privacyPolicyWarningMessage.getText();
		return text;
	}
	
	public String retrieveFirstnameWarningMessage() {
		String text = firstnameWarningMessage.getText();
		return text;
	}
	
	public String retrieveLastnameWarningMessage() {
		String text = lastnameWarningMessage.getText();
		return text;
	}
	
	public String retrieveEmailWarningMessage() {
		String text = emailWarningMessage.getText();
		return text;
	}
	
	public String retrieveDuplicateEmailWarningMessage() {
		String text = duplicateEmailWarningMessage.getText();
		return text;
	}
	
	
	public String retrieveTelephoneWarningMessage() {
		String text = telephoneWarningMessage.getText();
		return text;
	}
	
	public String retrievePasswordWarningMessage() {
		String text = passwordWarningMessage.getText();
		return text;
	}
	
	public String retrieveWrongConfirmPasswordWarningMessage() {
		String text = wrongConfirmPasswordWarningMessage.getText();
		return text;
	}
	
	
	}
	
}
