package com.pom_with_pageFactory_MercuryTours.Scripts;

import org.testng.annotations.Test;

import com.pom_with_pageFactory_MercuryTours.Pages.RegisterPage;


public class RegisterTest extends LoginTest_Excel {    //extends LoginTest-to get the - after login - driver details
	
	  @Test
	  public void registerPageDetails() throws InterruptedException {
		 
		  RegisterPage rpobj=new RegisterPage(driver);
		  rpobj.registerDetails();
	  }
}
