package pageObjects;

 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.CacheLookup;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class LoginPage extends BaseClass {
  
  public LoginPage (WebDriver webDriver)
  {
   PageFactory.initElements(webDriver, this);
  }
  
  @FindBy(xpath="//input[@id='email']")
  @CacheLookup
  WebElement inputUsername;
  
  
  
  @FindBy(xpath ="//input[@id='pass']")
  @CacheLookup
  WebElement inputPassword;
  
  
  
  @FindBy(xpath="//button[@name='login']")
  @CacheLookup
  WebElement btnLogin; 
  
  
  
  @FindBy(xpath="//div/a[1][@aria-label='Facebook']")
  @CacheLookup
  WebElement divHomePageTitle;
  
  @FindBy(xpath="//div[contains(text(),'The email')]")
  @CacheLookup
  WebElement divErrorMsgUN;
  
  @FindBy(xpath="//div[contains(text(),'The password')]")
  @CacheLookup
  WebElement divErrorMsgPWD;
  
    
  public void SetUserName(String uName) {
   inputUsername.clear();
   inputUsername.sendKeys(uName);
  }
  
   
  public void SetPassword(String pwd) {
   inputPassword.clear();
   inputPassword.sendKeys(pwd);
  }  
  
  public void ClickBtnLogin() {
   btnLogin.click();
  }
  
    
  public String getHomePgTitle() {
    return divHomePageTitle.getAttribute("aria-label");  
  }
  
  public String getErrMsgUN() {
    return divErrorMsgUN.getText();  
  }
  
  public String getErrMsgPWD() {
    return divErrorMsgPWD.getText();  
  }
  
  
}