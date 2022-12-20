package stepDefinitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.Helper;
import stepDefinitions.BaseClass;

public class LoginSteps extends BaseClass {
 
 @Given("User Launches Chrome Browser")
 public void user_launches_chrome_browser() {
   loginPage = new LoginPage(Helper.getDriver());   
 }

 @When("user opens facebook  portal link {string}")
 public void user_opens_facebook_portal_link(String url) {
    Helper.openPage(url);    
 }
 
 @Then("User should see the  page title {string}")
 public void user_should_see_the_page_title(String string) {
   String loginPgTitle = Helper.getTitle();
   Assert.assertEquals(string, loginPgTitle); 
 }
 
 @When("User enters Username as {string} and Password as {string}")
 public void user_enters_username_as_and_password_as(String userName, String password) {
    if(userName.equalsIgnoreCase("Valid") && password.equalsIgnoreCase("Valid"))
    {
    userName= Helper.GetUserName();
    password= Helper.GetPassword();
    }
  loginPage.SetUserName(userName);
  loginPage.SetPassword(password);  
  
  System.out.println("User Name: "+ userName);
  System.out.println("Password: "+ password);
 }

 @Then("User clicks on Login button with expected status as {string}")
 public void user_clicks_on_login_button(String expectedStatus) {
  loginPage.ClickBtnLogin();
  
  if (expectedStatus == "Both Fail")
  {
   String userNameValMessage = loginPage.getErrMsgUN();
   String pwdValMessage= loginPage.getErrMsgUN();
   
   Assert.assertEquals("Please enter your user name", userNameValMessage);
   Assert.assertEquals("Please enter your password", pwdValMessage);
   return;
  }
  else if (expectedStatus == "Missing Password")
  {
   String commonMsg =loginPage.getErrMsgPWD();
   Assert.assertEquals("Invalid username and password Please try again",commonMsg);
   return;
  }
 }
 
 @Then("User should see the Facebook Home page on successful login status {string}")
 public void user_should_see_the_facebook_home_page_on_successful_login_status(String status) throws InterruptedException { 
  
 
  if (status.equalsIgnoreCase("Pass"))
  {
   Assert.assertEquals(loginPage.getHomePgTitle(), "Facebook");
   System.out.println("Login Passed");
   Assert.assertEquals(Helper.getTitle(), "facebook");
  } 
 }
}