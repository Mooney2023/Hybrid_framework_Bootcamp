package com.tutorialsNinja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LonginTest {

	@Test(priority=1)
	public void verifylonginwithValidCredentials() {
		
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://tutorialsninja.com/demo");
		 driver.findElement(By.linkText("my Account")).click();
		 driver.findElement(By.linkText("Longin")).click();
		 driver.findElement(By.id("input-email")).click();
		 driver.findElement(By.id("input-password")).click();
		 driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		 
} 
	}      