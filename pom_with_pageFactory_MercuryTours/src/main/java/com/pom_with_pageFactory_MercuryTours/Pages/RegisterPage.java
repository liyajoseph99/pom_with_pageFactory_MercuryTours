package com.pom_with_pageFactory_MercuryTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement register;
	
	public RegisterPage(WebDriver driver) {  //constructor, passing the parameter driver,calling from  LoginTest
		this.driver=driver;
		PageFactory.initElements(driver, this); //to pass the driver value to pagefactory(ie, @FindBy)
	}
	
	public void registerDetails() throws InterruptedException {
		Thread.sleep(2000);
		register.click();
	}
}
