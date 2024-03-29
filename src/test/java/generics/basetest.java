package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class basetest implements Autoconstant
{
	public static WebDriver driver;

@BeforeSuite
public void suiteExecution()
{
Reporter.log("Execution of suite started",true);	
}
@BeforeTest
public void testExecution()
{
	Reporter.log("Execution of test started",true);
}
@BeforeClass
public void classExecution() throws IOException
{
	Reporter.log("Execution of class started",true);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	FileInputStream fis=new FileInputStream(properties_path);
	Properties properties=new Properties();
	properties.load(fis);
	driver.get(properties.getProperty("url"));
}
@AfterClass
public void classExecutionend()
{
	
	basepage close=new basepage();
	close.closeBrowser(driver);
	Reporter.log("class execution ended",true);
}
@AfterSuite
public void suiteExecutionend()
{
Reporter.log("Execution of suite ended",true);	
}
@AfterTest
public void testExecutionend()
{
	Reporter.log("Execution of test ended",true);
}
}
