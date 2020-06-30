package appiumdemo;

import java.net.MalformedURLException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class moneyExchange extends mdealerTest{
	
	static String otp;
	static String notMetfoneNum;
	static String terminateNum;
	static String inactiveNum;
	static String activeNum;
	static String errorMessageExpected = "Phone number is not exited or not correct. Please check again!";
	static String errorMessageNotMefoneNum = "Phone number is not Metfone. Please check again!";
	static String strInactiveNum = "INACTIVE";
	static String strTerminateNum = "TERMINATE";
	static String strNotMetfoneNum = "NOT METFONE NUMBER";
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		inactiveNum = "068612873"; //Number that is inactive
		terminateNum = "0883232650"; //Number that is terminated
		notMetfoneNum = "081789781"; //Not Metfone Number
		activeNum = "0978954663"; //Active Number for this services
		
		moneyXchangeSuccess(activeNum);
		moneyXchangeFail(inactiveNum,strInactiveNum);
		moneyXchangeFail(terminateNum,strTerminateNum);
		moneyXchangeFail(notMetfoneNum,strNotMetfoneNum);

	}
	
	public static void otpExtract() {
		Scanner scan = new Scanner(System.in);
		otp = scan.next();
		
		
	}
	public static void moneyXchangeSuccess (String num) throws MalformedURLException, InterruptedException {
		System.out.println();
		System.out.println("Starting Test Case...");

		successLoginFunction ();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.LinearLayout")));
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[6]/android.widget.LinearLayout").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/lnExchange")));
		driver.findElementById("com.metfone.mdealer:id/lnExchange").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/rootView")));
		driver.findElementById("com.metfone.mdealer:id/etReceiverPhone").sendKeys(num);
		driver.findElementById("com.metfone.mdealer:id/etPin").sendKeys("010101");
		driver.findElementById("com.metfone.mdealer:id/btnContinue").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/etOTP")));
		System.out.println("Enter OTP in the Terminal");
		otpExtract();
		System.out.println("Your Otp is: "+otp);
		driver.findElementById("com.metfone.mdealer:id/etOTP").sendKeys(otp);
		
		driver.findElementById("com.metfone.mdealer:id/btnSubmit").click();
		
	
 
		//driver.quit();

	}
	public static void moneyXchangeFail (String num, String str) throws MalformedURLException, InterruptedException {
		System.out.println();
		System.out.println("Starting Test Case...");
		System.out.println("Check in case phone number is "+ str);
		successLoginFunction ();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.LinearLayout")));
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[6]/android.widget.LinearLayout").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/lnExchange")));
		driver.findElementById("com.metfone.mdealer:id/lnExchange").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/rootView")));
		driver.findElementById("com.metfone.mdealer:id/etReceiverPhone").sendKeys(num);
		driver.findElementById("com.metfone.mdealer:id/etPin").sendKeys("010101");
		driver.findElementById("com.metfone.mdealer:id/btnContinue").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.metfone.mdealer:id/ld_message")));
		String errorMessageTest = driver.findElementById("com.metfone.mdealer:id/ld_message").getText();
		System.out.println("Display the message: "+ errorMessageTest);
		if(num.contains(notMetfoneNum)) //parameter input is not metfone number 
		{
			if(errorMessageTest.contains(errorMessageNotMefoneNum)) //the error message expected from not Metfone number matched the test error message
			{
				System.out.println("Test Case Pass!!!");
			}
			else //the error message expected DOES NOT MATCH the test error message 
			{ 
				System.out.println("Test Case Fail!!!");
				System.out.println("Expected Message "+errorMessageNotMefoneNum);
			}
		}
		else 
		{
			if(errorMessageTest.contains(errorMessageExpected)) //the error message expected for number terminate or inactive match the tested error message
			{
				System.out.println("Test Case Pass!!!");
			}
			else ////the error message expected for number terminate or inactive DOES NOT MATCH the tested error message
			{
				System.out.println("Test Case Fail!!!");
			}
		}
		
		driver.quit();

	}

	
	
	
}
