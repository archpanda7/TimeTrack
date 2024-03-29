package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.Autoconstant;
import generics.basepage;
import generics.excelLibrary;

public class ActitimeLogin extends basepage implements Autoconstant
{

public WebDriver driver;

@FindBy(id = "username")
private WebElement usernameTextfield;

@FindBy(xpath = "//input[@placeholder='Password']")
private WebElement passwordTextfield;

@FindBy(id = "keepLoggedInCheckBox")
private WebElement keepmeloggedinCheckbox;

@FindBy(id = "loginButton")
private WebElement loginButton;

public ActitimeLogin(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void loginMethod() throws Throwable 
{
	waitVisibilityofElement(driver, usernameTextfield);
	usernameTextfield.sendKeys(excelLibrary.retrivingDatafromCellsandRows(sheet_login,1,0));
     excelLibrary.getaddresstypevalue(sheet_login, 1, 0);
	waitVisibilityofElement(driver, passwordTextfield);
	passwordTextfield.sendKeys(excelLibrary.retrivingDatafromCellsandRows(sheet_login, 1, 1));
	excelLibrary.getaddresstypevalue(sheet_login, 1, 1);
	waitVisibilityofElement(driver, loginButton);
	javascriptClick(driver, loginButton);
}
}