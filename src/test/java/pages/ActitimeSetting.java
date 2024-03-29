package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generics.Autoconstant;
import generics.basepage;

public class ActitimeSetting extends basepage implements Autoconstant
{
	public WebDriver driver;
  @FindBy(xpath="(//a[@class='item_link'])[5]")
  private WebElement typesOfworkButton;
  @FindBy(xpath="(//a[@class='item_link'])[6]")
  private WebElement leaveTypesbutton;
  @FindBy(xpath="(//a[@class='item_link'])[7]")
  private WebElement priorityButton;
  public ActitimeSetting(WebDriver driver)
  {
	    this.driver=driver;
		PageFactory.initElements(driver, this);  
  }
  public void typesOfworkMethod()
  {
	  waitVisibilityofElement(driver, typesOfworkButton);
		javascriptClick(driver, typesOfworkButton);
  }


}
