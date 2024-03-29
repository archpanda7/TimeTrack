package generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class basepage extends excelLibrary implements Autoconstant
{
	//webDriver interfaces
 public void closeBrowser(WebDriver driver)
 {
	 
	 driver.quit();
 }
 public void validateTitle(WebDriver driver,String expectedTitle)
 { 
     Assert.assertEquals(driver.getTitle(),expectedTitle,"titles are not matching");
     Reporter.log("Titles are matching");
     
 }
 public void validateUrl(WebDriver driver,String expectedUrl)
 {
	 Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"url are not matching");
	 Reporter.log("url are matching");
 }
 public void getpagesource(WebDriver driver,String pagesource)
 {
	pagesource= driver.getPageSource();
	Reporter.log(pagesource);
 }
 public void maximuzeBrowser(WebDriver driver)
 {
	 driver.manage().window().maximize();
 }
 public void minimizeBrowser(WebDriver driver)
 {
	 driver.manage().window().minimize();
 }
 
 //WebElement interface
 public void validateText( WebDriver driver,WebElement element,String expectedText)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	Assert.assertEquals(element.getText(), expectedText,"text are not matching"); 
 }
 public void clearText(WebElement element,WebDriver driver)
 {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 element.clear();
	 Assert.assertEquals(element.getAttribute("value").isEmpty(),true,"text is not clear");
 }
 public void clearDelete(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 element.sendKeys(Keys.CONTROL,"a");
	 element.sendKeys(Keys.DELETE);
	 Assert.assertEquals(element.getAttribute("value").isEmpty(),true,"text is  not deleted");
 }
 public void clearBackspace(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 element.sendKeys(Keys.CONTROL,"a");
	 element.sendKeys(Keys.BACK_SPACE);
	 Assert.assertEquals(element.getAttribute("value").isEmpty(), true,"text is not blank");
 }
 public void clearSinglebackSpace(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 element.sendKeys(Keys.BACK_SPACE);
 }
 public void copypaste(WebDriver driver,WebElement copyElement,WebElement pasteElement,String text,String expectedText)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(copyElement));
	 wait.until(ExpectedConditions.visibilityOf(pasteElement));
	 copyElement.sendKeys(Keys.CONTROL,"a");
	 copyElement.sendKeys(Keys.CONTROL,"c");
	 pasteElement.sendKeys(Keys.CONTROL,"v");
	 Assert.assertEquals(pasteElement.getAttribute("value").equals(text),expectedText,"not copied properly");
 }
 public void cutpaste(WebDriver driver,WebElement copyElement,WebElement pasteElement,String text,String expectedText)
 {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(copyElement));
	 wait.until(ExpectedConditions.visibilityOf(pasteElement));
	 copyElement.sendKeys(Keys.CONTROL,"a");
	 copyElement.sendKeys(Keys.CONTROL,"c");
	 pasteElement.sendKeys(Keys.CONTROL,"v");
	 Assert.assertEquals(pasteElement.getAttribute("value").equals(text),expectedText,"text is copied");
	  }
public void enter(WebDriver driver,WebElement element)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 element.sendKeys(Keys.ENTER);
}
public void getElementAttribute(WebElement element,WebDriver driver,String attribute,String value,String expectedAttribute)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Assert.assertEquals(element.getAttribute(attribute).equals(value),expectedAttribute,"attribute is not matching");
}
public void getCssvalue(WebElement element,WebDriver driver,String Cssvalue)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Reporter.log(element.getCssValue(Cssvalue),true);
}
public void getElementLocation(WebElement element,WebDriver driver)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Point point= element.getLocation();
	 Reporter.log("x-axis location of the element is :" +point.getX(),true);
	 Reporter.log("y-axis location of the element is :" +point.getY(),true);
}
public void getElementSize(WebDriver driver,WebElement element)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Dimension dimension= element.getSize();
	 Reporter.log("width of the element is"+ dimension.getWidth(),true);
	 Reporter.log("height of the element is"+ dimension.getHeight(),true);
}
public void getElementTagName(WebDriver driver,WebElement element,String expectedTagName )
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Assert.assertEquals(element.getTagName(),expectedTagName,"tag name is not displayed");
}
public void replaceElementText(WebElement sourceElement,WebElement targetElement,String expectedText ,WebDriver driver,String targetValue)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(sourceElement));
	 wait.until(ExpectedConditions.visibilityOf(targetElement));
	 sourceElement.clear();
	 targetElement.sendKeys(targetValue);
	 Assert.assertEquals(targetElement.getAttribute("value"),expectedText,"element is not replaced");
}
public void elementDisplayed(WebElement element,WebDriver driver)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Assert.assertEquals(element.isEnabled(),"true","element is  not displayed");
}
public void elementEnabled(WebElement element,WebDriver driver)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Assert.assertEquals(element.isEnabled(),"true","element is not enabled");
}
public void elementSelected(WebElement element,WebDriver driver)
{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 Assert.assertEquals(element.isSelected(),"true","element is not selected");
}
//Select Class
	public void selectByText(WebElement element, String text,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement element,int index,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void selectByvalue(WebElement element,String value,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void deselectByIndex(WebElement element,int index,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	public void deselectByvalue(WebElement element,String value,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	public void deselectByText(WebElement element, String text,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	public void deselectAll(WebElement element,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		select.deselectAll();
	}
	public void selectIsMultiple(WebElement element,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select=new Select(element);
		Assert.assertEquals(select.isMultiple(), true,"dropdown is not multiple");
	}
	public void allOptions(WebElement element,List<WebElement> elements,WebDriver driver,int expectedSize)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		 Select select=new Select(element);
		 List<WebElement> allOptions=select.getOptions();
		 Reporter.log("size of the list is : "+allOptions.size(),true);
		 Assert.assertEquals(allOptions.size(),expectedSize,"size is not matching");
	}
	public void getSelectedoptions(WebElement element,List<WebElement> elements,WebDriver driver,int expectedSize)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		 Select select=new Select(element);
		 List<WebElement> allselectedOption=select.getAllSelectedOptions();
		 Reporter.log("size of list is :"+ allselectedOption.size(),true);
		 Assert.assertEquals(allselectedOption.size(),expectedSize,"size is not as expected");
		 
	}
	public void getFirstSelectedoption(WebElement element,WebDriver driver ,String expectedText)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(element));
		 Select select=new Select(element);
		 WebElement firstSelectedOption = select.getFirstSelectedOption();
		 Reporter.log("first selected option is :"+ firstSelectedOption,true);
		 Assert.assertEquals(firstSelectedOption.getText(),expectedText,"first selected option is not matching");
	}
	
	//Actions Class
	public void moveToElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public  void clickelement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions=new Actions(driver);
		actions.click(element).perform();
	}
	public  void doubleclickelement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void pause(WebDriver driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.pause(5000);
	}
	public void scrollelement(WebDriver driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.scrollToElement(element).perform();
	}
	
	
	
	//Robot Class
	public void robotEnter() throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void robotcopy() throws AWTException
	{
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
	}
	public void robotpaste() throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
	}
	
	//synchronization
	public void waitVisibilityofElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Alert Interface
	public void alertAccept(WebDriver driver)
	{
		Reporter.log("text of alert is : "+driver.switchTo().alert().getText(), true);
		driver.switchTo().alert().accept();
	}
	
	//JavasriptExecutor Interface
	public void javascriptClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void javascriptEnter(WebDriver driver, WebElement element, String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(value, element);
	}
}

