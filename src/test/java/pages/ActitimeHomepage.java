package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.Autoconstant;
import generics.basepage;

public class ActitimeHomepage extends basepage implements Autoconstant 
{
	public WebDriver driver;
   @FindBy(xpath="(//div[@class='label'])[1]")
   private WebElement timeTrackbutton; 
   @FindBy(xpath="(//div[@class='label'])[2]")
   private WebElement tasksButton;
   @FindBy (xpath="(//div[@class='label'])[3]")
   private WebElement reportsButton;
   @FindBy (xpath="(//div[@class='label'])[4]")
   private WebElement userButton;
   @FindBy(xpath="(//div[@class='popup_menu_icon'])[1]")
   private WebElement calendarsDropdown;
   @FindBy(xpath="(//div[@class='popup_menu_icon'])[2]")
   private WebElement settingsDropdown;
   @FindBy(xpath="(//div[@class='popup_menu_icon'])[3]")
   private WebElement browserExtensiondropdown;
   @FindBy(xpath="(//div[@class='popup_menu_icon'])[4]")
   private WebElement demoDataloadedDropdown;
   @FindBy(id = "logoutLink")
	private WebElement logountLink;
   
    public ActitimeHomepage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
    }
    public void logoutMethod() throws InterruptedException
	{
		waitVisibilityofElement(driver, logountLink);
		javascriptClick(driver, logountLink);
	}

   
}
