package testcases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generics.basetest;
import pages.ActitimeHomepage;
import pages.ActitimeLogin;
@Listeners(generics.screenshot.class)
public class TC_Actitime_Login_Logout extends basetest
{

  @Test
  public void Login() throws Throwable
  {
	ActitimeLogin login=new ActitimeLogin(driver) ;
	login.loginMethod();
  }
  @Test(dependsOnMethods = "Login")
  public void logout() throws InterruptedException
  {
	  ActitimeHomepage logout=new ActitimeHomepage(driver);
	  logout.logoutMethod();
  }
 
}
