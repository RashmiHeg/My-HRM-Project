package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	
	PomLogin log;
	SoftAssert sa;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		log= new PomLogin();
		sa= new SoftAssert();
		screenshots("Login");
	}
	
	@Test
	public void Title() {
		String actual=log.verify();
		Assert.assertEquals(actual, "OrangeHRM");
	}
	
	@DataProvider
	public Object[][] Details() {
		Object result[][] = ExcelSheet.readdata("Sheet1");
		return result;
	}
	@Test(dataProvider="Details")
	public void Login(String name, String pass) throws InterruptedException {
		log.typeusername(name);
		log.typepassword(pass);
		Thread.sleep(5000);
	}
/*	@Test
	public void Validusername() throws InterruptedException {
		
		log.typeusername(prop.getProperty("username"));
		log.typepassword(prop.getProperty("password"));
		log.clickbtn();
		String act= log.verifyurl();
		sa.assertEquals(act, "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		sa.assertAll();
	}*/
	
	@Test
	public void Clickforgotpassword() {
		log.forgotpassword();
		screenshots("forgot");
		String act= log.verifyurl();
		sa.assertEquals(act, "https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode");
		sa.assertAll();
	}
	
	@Test
	public void ClickLinked() {
		log.clicklinkedin();  
		
		String act= log.verifynewwindow();
		sa.assertEquals(act,"https://www.linkedin.com/signup/cold-join?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2Fgroups%3Fhome%3D%26gid%3D891077&trk=login_reg_redirect");
		sa.assertAll();
	} 
	
	@Test
	public void clickfacebook() throws InterruptedException {
		log.clickfacebook();
		Thread.sleep(2000);
		String act= log.verifynewwindow();
		sa.assertEquals(act,"https://www.facebook.com/OrangeHRM");
		sa.assertAll();
	}
	
	@Test
	public void clicktwitter() {
		log.clicktwitter();
	}
	
	@Test
	public void clickyoutube() {
		log.clickyoutube();
	}
	
	
	
	@AfterMethod
	public void close() {
		
		driver.close();
	}  

}
