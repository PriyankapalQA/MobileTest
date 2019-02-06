package mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class NewTest {
	
	AndroidDriver<WebElement> driver;
	
	@BeforeClass
	public void Setup() throws MalformedURLException {
		try{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability("APP_PACKAGE","io.selendroid.testapp");
		cap.setCapability("avd", "Test_NexusS");
		cap.setCapability("APP_ACTIVITY", "io.selendroid.testapp.HomeScreenActivity");
		
		cap.setCapability("browserName"," ");
				
    //  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	//	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "2.3");
	//	cap.setCapability(MobileCapabilityType.APP, myApp);
	
		cap.setCapability("app","C:/Users/priyankap948/AppData/Local/Android/Sdk/platform-tools/selendroid-test-app.apk");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
  @Test
  public void f() {
	  
	  System.out.println("hiii");
	  
	//  driver.findElement(By.id("buttonStartWebview")).click();
	  
	 driver.findElement(By.id("my_text_field")).sendKeys("Hello");
	 String a = driver.findElement(By.id("waitingButtonTest")).getText();
	 System.out.println(a);
//	 driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
	 driver.findElement(By.id("visibleButtonTest")).click();
	 String b=  driver.findElement(By.id("visibleTextView")).getText();
	 System.out.println(b);
	 Assert.assertEquals(b, "Text is sometimes displayed");
	 
  }
}
