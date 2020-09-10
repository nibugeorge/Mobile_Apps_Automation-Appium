package Tests;

import PageFunctions.CaptchaFunctions;
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

public class CaptchaTests {
    public static AppiumDriver<MobileElement> driver;
    LoginFunctions loginFunctions;
    CaptchaFunctions captchaFunctions;

    String image1;
    String cap1,cap2;
    int result1;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeMethod
    public void Setup() throws Exception {
        report = ExtentManager.Instance();
        //AppiumServer.StartAppium();
        driver= Common.appDriver();
        loginFunctions=new LoginFunctions(driver);
        captchaFunctions=new CaptchaFunctions(driver);
        loginFunctions.UserLogin("user@qabify.com","1234Abc");
    }

    @Test(priority = 1)
    public void CaptchaDisplayedTest()  {
        try{
            logger=report.startTest("Captcha Displayed Test");
            if(captchaFunctions.CaptchaDisplayed())
            {
                image1=Common.captureScreenshot(driver,"captcha_pass");
                logger.log(LogStatus.PASS, "Captcha value is displayed on captcha screen"+ logger.addScreenCapture(image1));
                cap1=captchaFunctions.GetCaptcha();


            }
            else {
                image1 = Common.captureScreenshot(driver, "captcha_fail");
                logger.log(LogStatus.FAIL, "Captcha value is not displayed on captcha screen" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 2)
    public void UniqueCaptchaTest()  {
        try{
            logger=report.startTest("Unique Captcha Test");
            if(captchaFunctions.CaptchaDisplayed())
            {
                cap2=captchaFunctions.GetCaptcha();
                if(!cap1.equals(cap2)){
                    image1=Common.captureScreenshot(driver,"uniquecaptcha_pass");
                    logger.log(LogStatus.PASS, "Different captcha is displayed after every login"+ logger.addScreenCapture(image1));
                }
                else {
                    image1 = Common.captureScreenshot(driver, "uniquecaptcha_fail");
                    logger.log(LogStatus.FAIL, "Different captcha is not displayed after every login" + logger.addScreenCapture(image1));
                }
            }

        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 3)
    public void EstimateScreenTest()  {
        try{
            logger=report.startTest("Estimate Screen Test");
            if(captchaFunctions.EstimateScreen())
            {
                image1=Common.captureScreenshot(driver,"estimate_pass");
                logger.log(LogStatus.PASS, "User is able to proceed to Estimate screen"+ logger.addScreenCapture(image1));
                cap1=captchaFunctions.GetCaptcha();


            }
            else {
                image1 = Common.captureScreenshot(driver, "estimate_fail");
                logger.log(LogStatus.FAIL, "User is not able to proceed to Estimate screen" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 4)
    public void CaptchaFormatTest()  {
        try{
            logger=report.startTest("Captcha Format Test");
            if(captchaFunctions.CaptchaFormat(captchaFunctions.GetCaptcha()))
            {
                image1=Common.captureScreenshot(driver,"capformat_pass");
                logger.log(LogStatus.PASS, "Captcha Format is an integer with 3 digits"+ logger.addScreenCapture(image1));
            }
            else {
                image1 = Common.captureScreenshot(driver, "capformat_fail");
                logger.log(LogStatus.FAIL, "Captcha Format is not proper" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 5)
    public void ContentCheckTest()  {
        try{
            logger=report.startTest("Captcha Screen Content Test");
            if(captchaFunctions.ContentCheck())
            {
                image1=Common.captureScreenshot(driver,"capcontent_pass");
                logger.log(LogStatus.PASS, "Captcha screen is displayed with correct content"+ logger.addScreenCapture(image1));
            }
            else {
                image1 = Common.captureScreenshot(driver, "capcontent_fail");
                logger.log(LogStatus.FAIL, "Login screen is not displayed with correct content" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
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
