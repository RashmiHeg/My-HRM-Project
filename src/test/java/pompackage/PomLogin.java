package pompackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;
import utility.TimeUtils;

public class PomLogin extends BaseHRMClass {
	
	//object repository
	@FindBy(id="txtUsername") WebElement username;
	@FindBy(id="txtPassword") WebElement password;
	@FindBy(id="btnLogin")  WebElement loginbtn;
	@FindBy(linkText="Forgot your password?") WebElement forgotpass;
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[1]/img") WebElement linked;
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[2]/img") WebElement facebook;
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[3]/img") WebElement twitter;
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[4]/img") WebElement youtube;
	
	//initiate page elements
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String name) {
		username.sendKeys(name);
	}
	
	public void typepassword(String value) {
		password.sendKeys(value);
	}
	
	public void clickbtn() {
		loginbtn.click();
	}
	
	public String verifyurl() {
		return driver.getCurrentUrl();
		
	}
	public String verify() {
		return driver.getTitle();
	}
	public String verifynewwindow() {
		Set<String> hands= driver.getWindowHandles();
		String original= driver.getWindowHandle();
		Iterator<String> iteration = hands.iterator();
		while(iteration.hasNext()) {
			String newwin = iteration.next();
			if(!original.equalsIgnoreCase(newwin)) {
				driver.switchTo().window(newwin);
			}
		}
	return driver.getCurrentUrl();
	}
	
	public void forgotpassword() {
		forgotpass.click();
	}
	
	public void clicklinkedin() {
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click()",linked);
		//driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS);
		linked.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void clickfacebook()  {
		facebook.click();
	}
	public void clicktwitter() {
		twitter.click();
	}
	public void clickyoutube() {
		youtube.click();
	}
}
