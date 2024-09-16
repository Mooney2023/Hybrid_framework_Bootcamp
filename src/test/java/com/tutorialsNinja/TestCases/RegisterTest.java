package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.TN.TestCases.AccountSuccessPage;
import com.QA.TN.TestCases.RegisterPage;
import com.tutorialsNinja.Pages.HomePage;

import dev.failsafe.internal.util.Assert;

public class RegisterTest {

	
	
		
		public RegisterTest() throws Exception {
			super();
		}
		
		public WebDriver driver;
		public com.tutorialsNinja.Pages.RegisterPage registerpage;
		public HomePage homepage;
		public AccountSuccessPage accountsuccesspage;
		
		
		@BeforeMethod
		public void registerSetup() {
			driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
			homepage = new HomePage(driver);
			registerpage = homepage.combiningTwoActionsToNavigateToRegisterPage();
		}
		
		@Test(priority=1, dataProvider = "TNRegister", dataProviderClass = ExcelCode.class)
		public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone, String password, String confirmpassword) {
			accountsuccesspage = registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(firstname, lastname, Util.emailWithDateTimeStamp(), telephone, password, confirmpassword);
			Assert.assertTrue(accountsuccesspage.validateAccountSuccessCreatedMessage());
		}
		
		@Test(priority=2)
		public void verifyRegisterWithAllDetails() {
			accountsuccesspage = registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"),
					dataProp.getProperty("lastname"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), 
					prop.getProperty("validPassword"));
			Assert.assertTrue(accountsuccesspage.validateAccountSuccessCreatedMessage());
		}
		
		@Test(priority=3)
		public void verifyRegisterWithExistingEmail() {
			registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"),
					dataProp.getProperty("lastname"), prop.getProperty("validEmail"), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), 
					prop.getProperty("validPassword"));
			Assert.assertTrue(registerpage.retrieveDuplicateEmailWarningMessage().contains(registerpage.retrieveDuplicateEmailWarningMessage()));
			
		}
		
		@Test(priority=4)
		public void verifyRegisterWithWrongConfirmPassword() {
			registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstname"),
					dataProp.getProperty("lastname"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), 
					dataProp.getProperty("invalidPassword"));
			Assert.assertTrue(registerpage.retrieveWrongConfirmPasswordWarningMessage().contains(dataProp.getProperty("wrongconfirmPasswordWarning")));
			
		}
		
		@Test(priority=5)
		public void verifyRegisterWithNoDetails() {
			registerpage.clickOnContinueButton();
	        Object dataProp;
			Assert.assertTrue(registerpage.retrieveAllWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
	        		((Object) dataProp).getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), 
	        		((Object) dataProp).getProperty("invalidEmailWarning"),
	        		dataProp.getProperty("telephoneWarning"), 
	        		((Object) dataProp).getProperty("passwordWarning")));
	        
			ngMessage().contains( dataProp).getProperty("passwordWarning")));
		}
		
		

		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
}
