package generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class screenshot implements ITestListener
{
   public void onTestFailure(ITestResult result)
   {
	 TakesScreenshot ts=(TakesScreenshot)basetest.driver;
	 File srcfile=ts.getScreenshotAs(OutputType.FILE);
	 
	 String methodName=result.getName();
	Date date = Calendar.getInstance().getTime();
	String today=date.toString().replaceAll(":", "-");
	File destfile=new File("./failedscreenshot/"+ methodName+today+".png");
	try {
		FileHandler.copy(srcfile, destfile);
	} catch (IOException e) {
		
	}
   }
}
