package appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;

public class mdealerTest extends desiredCapabilities {
	static String usernameId = "com.metfone.mdealer:id/editText_phone_number"; //username textbox
	static String passwordId = "com.metfone.mdealer:id/editText_passWord"; //password textbox
	static String loginBtn = "com.metfone.mdealer:id/btn_login"; //login button
	 

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
//		testCase1(); //return true if test case 1 is successful
//		boolean isTrue = true;
//		if(testCase2() == isTrue) {
//			System.out.println("The default username is EMPTY \n Testcase 2: SUCCESS");
//		}
//		else {
//			System.out.println("The default username is NOT EMPTY \n Testcase 2: FAILED");	
//			
//		}
//		testCase3(); //check EMPTY input
//		testCase4(); //check hint text before input of username
//		testCase5(); //check Trim
//		testCase6(); //check default value of password
//		testCase7(); //check password is hidden by default
//		testCase8(); //check EMPTY input if password
//		testCase9(); //Check login with wrong username and password
//		testCase10(); //Check login with wrong username
//		testCase11(); //Check login with correct username and password

		
			successLoginFunction ();
		
		
	}
						

	
	private static void testCase1() throws MalformedURLException, InterruptedException {
		desiredCapabilitiesMethod();
	
		
		//check if username password textbox or login button is in the app or not
		
		if(driver.findElementsById(usernameId).isEmpty()||driver.findElementsById(passwordId).isEmpty()||driver.findElementsById(loginBtn).isEmpty()) 
		{
			System.out.println("Username Password and Login Button are NOT AVAILABLE");
			System.out.println("Testcase 1: FAILED");
		}
		else {
			System.out.println("Username Password and Login Button are AVAILABlE");
			System.out.println("Testcase 1: SUCCESS");
		}

		
	}
	private static boolean testCase2() throws MalformedURLException, InterruptedException {
		desiredCapabilitiesMethod();
		String usernameId = "com.metfone.mdealer:id/editText_phone_number"; //username textbox
		String usernameText= driver.findElementById(usernameId).getText();
		if(usernameText.equalsIgnoreCase("0xx xxx xxxx"))
		{
			return true;
	
			
		}
		else {
			return false;
	
		}
		
	}
	private static void testCase3()throws MalformedURLException, InterruptedException{
		desiredCapabilitiesMethod();
		if(testCase2()==true) {
			driver.findElementById(usernameId).click();
			driver.findElementById(loginBtn).click();
			System.out.println("Login Button is Clicked");
			if(driver.findElementById("com.metfone.mdealer:id/textView_phoneNumber_notify").isDisplayed()) {
				System.out.println("App ALERT \"Require information\" under username");
				System.out.println("Testcase 3: SUCESS");
			}
			else {
				System.out.println("App does NOT ALERT \"Require information\" under username");
				System.out.println("Testcase 3: FAILED");
			}
		
		}
		else {
			System.out.println("Username is not empty");
		}
		
	}
	private static void testCase4() throws MalformedURLException{
		desiredCapabilitiesMethod();
		driver.findElementById(usernameId).clear();
		System.out.println("The Hint text is "+driver.findElementById(usernameId).getText());
	}
	private static void testCase5() throws MalformedURLException{
		desiredCapabilitiesMethod();
		driver.findElementById(usernameId).sendKeys(" 12345 6 ");
		
	}
	private static void testCase6() throws MalformedURLException {
		desiredCapabilitiesMethod();
		String passwordText= driver.findElementById(passwordId).getText();
		if(passwordText.equalsIgnoreCase("Enter your password")){
			System.out.println("The default password value is EMPTY");
		}
		else {
			System.out.println("The default password value is NOT EMPTY");
		}
		
	}
	private static void testCase7() throws MalformedURLException{
		desiredCapabilitiesMethod();
		driver.findElementById(passwordId).sendKeys("123456");
		
	}
	private static void testCase8() throws MalformedURLException{
		desiredCapabilitiesMethod();
		driver.findElementById(passwordId).clear();
		System.out.println("The Hint text is "+driver.findElementById(passwordId).getText());
	}
	private static void testCase9() throws MalformedURLException{
		desiredCapabilitiesMethod();
		driver.findElementById(usernameId).sendKeys("018123321"); //username value
		driver.findElementById(passwordId).sendKeys("bhgvhfcyhcf"); //password value
		driver.findElementById(loginBtn).click();
	}
	private static void testCase10() throws MalformedURLException{
		desiredCapabilitiesMethod();
		driver.findElementById(usernameId).sendKeys("018123321"); //username value
		driver.findElementById(passwordId).sendKeys("123456"); //password value
		driver.findElementById(loginBtn).click();
	}

	public static void successLoginFunction() throws MalformedURLException, InterruptedException {
		desiredCapabilitiesMethod();
		  
		driver.findElementById(usernameId).sendKeys("0889361404"); //username value
		driver.findElementById(passwordId).sendKeys("123456"); //password value
		driver.findElementById(loginBtn).click();
		
//		Thread.sleep(2500);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/ld_color_area")));
		driver.findElementById("com.metfone.mdealer:id/ld_btn_no").click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/txtMessage")));
		driver.findElementById("com.metfone.mdealer:id/btnClose").click();
		
	}
	
}
