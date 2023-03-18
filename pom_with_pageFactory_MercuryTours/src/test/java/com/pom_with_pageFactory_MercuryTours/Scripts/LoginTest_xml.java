package com.pom_with_pageFactory_MercuryTours.Scripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pom_with_pageFactory_MercuryTours.Pages.LoginPage;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.Base;

public class LoginTest_xml extends Base {
	
	  @Test
	  @Parameters({"username1","password1"})
	  public void VerifyUsernamePasswordLogin(String username,String password) throws InterruptedException {
		  LoginPage lpobj1=new LoginPage(driver);  							//passing the parameter driver to the constructor LoginPage
		  lpobj1.loginDetailsTest1(username,password);						//passing username and password
		  
		  WebElement login=driver.findElement(By.xpath("//td/h3"));
		  String actual=login.getText();
		  String expected="Login Successfully";
		  SoftAssert obj=new SoftAssert();		
		  obj.assertEquals(actual, expected);
		  obj.assertAll();
	  }
	  
}
