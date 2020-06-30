package appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class desiredCapabilities  {
	static AndroidDriver<MobileElement> driver;
	

	public static void desiredCapabilitiesMethod() throws MalformedURLException //applauncher
	{
		
        String appId = "com.metfone.mdealer";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung S9");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","10");
        capabilities.setCapability("appPackage",appId);
        capabilities.setCapability("appActivity","com.metfone.mdealer.login.Login");
        capabilities.setCapability("noReset",true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub"); // URL of Appium Server
        driver = new AndroidDriver<MobileElement>(url,capabilities);
        
        
        
        
	}
}
