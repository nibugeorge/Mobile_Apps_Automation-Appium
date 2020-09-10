package Tests;

import PageFunctions.LoginFunctions;
import Utils.AppiumServer;
import Utils.Common;
import Utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;

public class LoginTests {
    public static AppiumDriver<MobileElement> driver;
    LoginFunctions loginFunctions;

    String image1;
    int result1;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeMethod
    public void Setup() throws Exception {
        report = ExtentManager.Instance();
        AppiumServer.StartAppium();
        driver= Common.appDriver();
        loginFunctions=new LoginFunctions(driver);
    }

    @Test(dataProvider = "credentials",priority = 1)
    public void LoginUserTest(String user,String pass)  {
        try{
            logger=report.startTest("Login User Test");
            result1=loginFunctions.UserLogin(user,pass);
            if(result1==1)
            {
                image1=Common.captureScreenshot(driver,"loginuser_pass_"+user);
                logger.log(LogStatus.PASS, "User login success"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "loginuser_fail_"+user);
                logger.log(LogStatus.FAIL, "User login failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 2)
    public void LoginButtonTest()  {
        try{
            logger=report.startTest("Login Button Test");
            if(!loginFunctions.LoginButton())
            {
                image1=Common.captureScreenshot(driver,"loginbutton_pass");
                logger.log(LogStatus.PASS, "Login button is disabled by default"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "loginbutton_fail");
                logger.log(LogStatus.FAIL, "Login button is enabled by default" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 3)
    public void PasswordFieldTest()  {
        try{
            logger=report.startTest("Password Field Test");
            if(loginFunctions.PassField("1234"))
            {
                image1=Common.captureScreenshot(driver,"passfield_pass");
                logger.log(LogStatus.PASS, "Password filed is encrypted"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "passfield_fail");
                logger.log(LogStatus.FAIL, "Password filed is not encrypted" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 4)
    public void BackNavigationTest()  {
        try{
            logger=report.startTest("Back Navigation Test");
            if(loginFunctions.BackNavigation(driver,"user@qabify.com","1234Abc"))
            {
                image1=Common.captureScreenshot(driver,"backnav_pass");
                logger.log(LogStatus.PASS, "Login screen is not displayed again"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "backnav_fail");
                logger.log(LogStatus.FAIL, "Login screen is displayed again" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 5)
    public void RelaunchAppTest()  {
        try{
            logger=report.startTest("Relaunch App Test");
            if(loginFunctions.RelaunchApp(driver,"user@qabify.com","1234Abc"))
            {
                image1=Common.captureScreenshot(driver,"relaunchapp_pass");
                logger.log(LogStatus.PASS, "Login screen is not displayed again"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "relaunchapp_fail");
                logger.log(LogStatus.FAIL, "Login screen is displayed again" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 6)
    public void ContentCheckTest()  {
        try{
            logger=report.startTest("Login Screen Content Test");
            if(loginFunctions.ContentCheck())
            {
                image1=Common.captureScreenshot(driver,"contentcheck_pass");
                logger.log(LogStatus.PASS, "Login screen is displayed with correct content"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "contentcheck_fail");
                logger.log(LogStatus.FAIL, "Login screen is not displayed with correct content" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @DataProvider(name="credentials")
    public Object[][] data1(){
        Object[][] data1=new Object[5][2];
        data1[0][0]="user@qabify.com";
        data1[0][1]="1234Abc";
        data1[1][0]="";
        data1[1][1]="";
        data1[2][0]="user@qabify.com";
        data1[2][1]="1234Abd";
        data1[3][0]="aa@@123";
        data1[3][1]="!@#$%^&";
        data1[4][0]="qwerty";
        data1[4][1]="\n\n";
        return data1;
    }

    @AfterMethod
    public void EndTest() {
        driver.closeApp();
        //driver.launchApp();
        report.endTest(logger);
        report.flush();
        driver.quit();
        //AppiumServer.StopAppium();
    }
}
