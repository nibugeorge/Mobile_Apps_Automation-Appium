package Utils;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Common {
    public static AppiumDriver<MobileElement> driver;
    public static Properties prop = new Properties();
    static InputStream input = null;


    public static AppiumDriver<MobileElement> appDriver() throws Exception
    {
        input = new FileInputStream(Config.PROP_FILEPATH);
        prop.load(input);

        if(prop.getProperty("platform").equals("android"))
        {
            androidSetup();
        }
        else if(prop.getProperty("platform").equals("ios"))
        {
            iosSetup();
        }
        return driver;
    }

    public static void iosSetup() throws Exception
    {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName",Config.PLATFORM_NAME_IOS);
        caps.setCapability("platformVersion", Config.PLATFORM_VERSION_IOS);
        caps.setCapability("deviceName",Config.DEVICE_NAME_IOS);
        caps.setCapability("language",Config.LANGUAGE);
        caps.setCapability("app", Config.IOS_APP_FILEPATH);
        caps.setCapability("bundelId",Config.BUNDLEID);
        caps.setCapability("automationName", Config.AUTOMATION_NAME);
        caps.setCapability("nativeInstrumentsLib",true);
        caps.setCapability("noReset",true);
        //caps.setCapability("udid",Config.UDID);
        //caps.setCapability("waitForAppScript","$.delay(8000); $.acceptAlert();");
        //caps.setCapability("fullReset",true);
        //caps.setCapability("nativeWebTap", true);
        driver = new IOSDriver<MobileElement>(new URL(Config.APPIUMSERVER_URL), caps);
    }

    public static void androidSetup() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("avd", Config.DEVICE_NAME_AND);
        capabilities.setCapability("deviceName", Config.DEVICE_NAME_AND);
        capabilities.setCapability("platformName", Config.PLATFORM_NAME_AND);
        capabilities.setCapability("app", Config.ANDROID_APP_FILEPATH);
        capabilities.setCapability("appPackage", Config.APP_PACKAGE);
        capabilities.setCapability("appActivity", Config.APP_ACTIVITY);
        capabilities.setCapability("fullReset",false);
        capabilities.setCapability("automationName", "uiautomator2");
        //capabilities.setCapability("resetKeyboard", "true");
        //capabilities.setCapability("platformVersion", Config.PLATFORM_VERSION_AND);
        //capabilities.setCapability("language",Config.LANGUAGE);
        driver = new AndroidDriver<MobileElement>(new URL(Config.APPIUMSERVER_URL), capabilities);
    }

    public static boolean isElementPresent(MobileElement mobileElement)
    {
        Boolean elementPresent = true;
        try
        {
            // assert mobileElement.getAttribute("text") != null;
            elementPresent = mobileElement.isDisplayed();
        }
        catch (NoSuchElementException ignored)
        {
            elementPresent = false;
        }
        return elementPresent;
    }

    public static void waitForPageToLoad(WebDriver driver, MobileElement id)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(id));
        }
        catch (Exception ignored)
        {
            //e.printStackTrace();
        }
    }

    public static String captureScreenshot(AppiumDriver<MobileElement> driver,String screenshotName) throws Exception
    {
        String device=driver.getCapabilities().getPlatform().toString();
        //String time=driver.getDeviceTime();
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest=new File(Config.SCREENSHOTS_FILEPATH+device+screenshotName+".png");
        Files.copy(src,dest);
        System.out.println("Screenshot taken");
        return dest.getAbsolutePath();
    }
}
