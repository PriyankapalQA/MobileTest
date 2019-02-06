package mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBrowserStack 
{
	AndroidDriver<WebElement> driver;
	public static String userName = "priyankapal2";
	public static String accessKey = "Lv4PBijFJkMARJVQynsF";

	@BeforeClass
	public void Setup() throws MalformedURLException 
	{
		try
		{
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("device", "Google Pixel");
		//	caps.setCapability("app", "bs://c073e420ea1bf37bd8d26851c19fda568f0b69a0");
			caps.setCapability("app", "bs://37320beb4c77d0d4af67252f2fcd3cd3641791fe");
			caps.setCapability("APP_PACKAGE","org.wikipedia.alpha");
			

			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
	@Test
	public void steps() 
	{
		try 
		{
			 driver.findElement(By.id("my_text_field")).sendKeys("Hello");
			 String a = driver.findElement(By.id("waitingButtonTest")).getText();
			 System.out.println(a);
//			 driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
			 driver.findElement(By.id("visibleButtonTest")).click();
			 String b=  driver.findElement(By.id("visibleTextView")).getText();
			 System.out.println(b);
			 Assert.assertEquals(b, "Text is sometimes displayed");
			 
			 driver.quit();
		}
		
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@AfterClass
		public void after()
		{
		//	driver.quit();

		}

	}