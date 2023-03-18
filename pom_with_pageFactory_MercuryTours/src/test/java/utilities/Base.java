package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Base {
	public WebDriver driver;
	 
	  @AfterMethod
	  public void afterMethod(ITestResult r) throws IOException {  //ITestResult pull cheyyan- get the details of @Test used before
		  if(ITestResult.SUCCESS==r.getStatus()) {
			//checking the status of the @Test is same as ITestResult.SUCCESS or not.
			  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(f, new File("C:\\Users\\ASUS\\Desktop\\screenshots\\"+r.getName()+".jpeg"));
		  }
	  }
	  

	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		  driver=new EdgeDriver();
		  driver.get("https://demo.guru99.com/test/newtours/index.php");          //login
		  driver.manage().window().maximize();
		
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }

}
