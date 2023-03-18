package com.pom_with_pageFactory_MercuryTours.Scripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pom_with_pageFactory_MercuryTours.Pages.LoginPage;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.Base;

public class LoginTest_Excel extends Base {
	
	  @Test(dataProvider = "dp")
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
	  
	  @DataProvider
	  public Object[][] dp() throws IOException, BiffException {		                   //import jxl,add dependency-org.apache.servicemix.bundles.jexcelapi,poi-ooxml-schemas,poi-scratchpad
		 FileInputStream f=new FileInputStream("C:\\Users\\ASUS\\Desktop\\testdata.xls");  //save as Excel 97-2003 worksheet , reading the file from the path
		 Workbook w=Workbook.getWorkbook(f);  				//getting the workbook from the file
		 Sheet s=w.getSheet("Sheet1");	  	  				//getting sheet from the workbook
		 int r=s.getRows();									//getting rows and columns
		 int c=s.getColumns();
		 String input[][]=new String[r][c];					//2d array input[][] with same size as excel.
		 for(int i=0;i<r;i++) {								//reading rows and columns
			 for(int j=0;j<c;j++) {
				 Cell cc=s.getCell(j, i);
				 input[i][j]=cc.getContents();
			 }		 
		 }
		 return input;										//returning input[][] to object[][] in dp()
	  }
}
