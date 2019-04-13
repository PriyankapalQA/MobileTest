package mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class TestEmulator {

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
	public void testWebView() {
		try{
	//  driver.findElement(By.id("buttonStartWebview")).click();
		}
		catch(Exception e)
		{

			System.out.println("method testWebView "+e.getMessage());
		}
	}
	
	
	@Test
	public void testRegistration()
	{
		try{
					
			if ( driver.findElement(By.id("input_adds_check_box")).isSelected() )
			{
				driver.findElement(By.id("input_adds_check_box")).click();
			}
	//		driver.findElement(By.id("startUserRegistration")).click();
	//		registration();
		}
			catch(Exception e)
			{
				System.out.println("method testRegistration "+e.getMessage());
			}
		
	}  
	
	@Test
	public void testWaitingProgressBar() {
		try{

			String a = driver.findElement(By.id("waitingButtonTest")).getText();
			driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("scrollView"))));

			registration();
		}
		catch(Exception e)
		{

			System.out.println("method f "+e.getMessage());
		}
	}


	public void registration()
	{
		try{
			driver.findElement(By.id("inputUsername")).sendKeys("Hello1");
			driver.findElement(By.id("inputEmail")).sendKeys("Hello@gmail.com");
			driver.findElement(By.id("inputPassword")).sendKeys("Hello");

			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"I accept adds"+"\").instance(0))").click();

			driver.findElement(By.id("inputName")).clear();
			driver.findElement(By.id("inputName")).sendKeys("Ms.Priyanka");

			driver.findElement(By.id("input_preferedProgrammingLanguage")).click();

			//  driver.findElement(By.xpath("//*[contains(text(),'Python')]")).click();

			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+"Python"+"\")").click();

			System.out.println("Button in Registration selected: "+driver.findElement(By.id("input_adds")).isSelected());
			
			if ( !driver.findElement(By.id("input_adds")).isSelected() )
			{
				driver.findElement(By.id("input_adds")).click();
			}

			driver.findElement(By.id("btnRegisterUser")).click();

			driver.findElement(By.id("buttonRegisterUser")).click();

			String name = driver.findElement(By.id("label_name_data")).getText();
			String progLang = driver.findElement(By.id("label_preferedProgrammingLanguage_data")).getText();
			String acceptAd = driver.findElement(By.id("label_acceptAdds_data")).getText();

			if (name.equalsIgnoreCase("Ms.Priyanka")&& progLang.equalsIgnoreCase("Python")&& acceptAd.equalsIgnoreCase("true"))	  
				System.out.println("All entered data correct: "+ name+ ","+progLang+","+acceptAd);
			else
				System.out.println("All entered data not correct: "+ name+ ","+progLang+","+acceptAd);

			driver.findElement(By.id("buttonRegisterUser")).click();
		}
		catch(Exception e)
		{

			System.out.println("method registration "+e.getMessage());
		}

	}

	@Test
	public void testDisplayText()
	{
		try
		{
			driver.findElement(By.id("my_text_field")).sendKeys("Hello");
			driver.findElement(By.id("visibleButtonTest")).click();
			//String b=  driver.findElement(By.id("visibleTextView")).getText(); 
			
			Assert.assertEquals(displayText("visibleTextView"), "Text is sometimes displayed"); 
		}
		catch(Exception e)
		{
			System.out.println("method testDisplayText "+e.getMessage());
		}
	}  
	
	public String displayText(String identifier)
	{
		return driver.findElement(By.id(identifier)).getText();
	} 

/*	@Test
	public void testAlert()
	{
		try{
		driver.findElement(By.id("showPopupWindowButton")).click();
		driver.switchTo().alert().accept();
		//System.out.println("Alert text: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();  // id : showPopupWindowButton
	//	driver.switchTo().alert().dismiss();
		
	}
	catch(Exception e)
	{
		System.out.println("method testAlert "+e.getMessage());
	}
	}   */
	
	@Test
	public void testLabel()
	{
		try{
		System.out.println("The displayed text is: "+ displayText("encodingTextview"));
		}
		catch(Exception e)
		{
			System.out.println("method testLabel "+e.getMessage());
		}
	}

	@Test
	public void testToast()
	{
		try{
	
		}
		catch(Exception e)
		{
			System.out.println("method testToast "+e.getMessage());
		}
	}

	
/*	@Test
	public void testException()
	{
		try{
			driver.findElement(By.id("exceptionTestButton")).click();
		}
		catch(Exception e)
		{
			System.out.println("method testException "+e.getMessage());
		}
	}   */

	
}
