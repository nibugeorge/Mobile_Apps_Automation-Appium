package Tests;

import PageFunctions.CaptchaFunctions;
import PageFunctions.EstimateFunctions;
import PageFunctions.LoginFunctions;
import PageFunctions.PastJourneyFunctions;
import Utils.AppiumServer;
import Utils.Common;
import Utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastJourneyTests {

    public static AppiumDriver<MobileElement> driver;
    LoginFunctions loginFunctions;
    CaptchaFunctions captchaFunctions;
    EstimateFunctions estimateFunctions;
    PastJourneyFunctions pastJourneyFunctions;

    String image1;
    String cap1,cap2;
    String price1;
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
        estimateFunctions=new EstimateFunctions(driver);
        pastJourneyFunctions=new PastJourneyFunctions(driver);
        loginFunctions.UserLogin("user@qabify.com","1234Abc");
        cap1=captchaFunctions.GetCaptcha();
        captchaFunctions.EstimateScreen();
        estimateFunctions.GetEsitmateLite(driver,"Atocha","Calle Pradillo, 42",cap1);
        price1=estimateFunctions.ReturnEsitmate();
        estimateFunctions.RequestCar();
    }

    @Test(priority = 1)
    public void CheckEstimateTest()  {
        try{
            logger=report.startTest("Check Estimate Test");
            if(pastJourneyFunctions.CheckEstimate(price1))
            {
                image1=Common.captureScreenshot(driver,"checkest_pass");
                logger.log(LogStatus.PASS, "Estimate is displayed correctly on past journeys screen"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "checkest_fail");
                logger.log(LogStatus.FAIL, "Estimate is not displayed correctly on past journeys screen" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 2)
    public void CheckTripTest()  {
        try{
            logger=report.startTest("Check Trip Test");
            if(pastJourneyFunctions.CheckTrip("Atocha","Calle Pradillo, 42"))
            {
                image1=Common.captureScreenshot(driver,"checktrip_pass");
                logger.log(LogStatus.PASS, "Source and destination is displayed correctly on past journeys screen"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "checktrip_fail");
                logger.log(LogStatus.FAIL, "Source and destination is not displayed correctly on past journeys screen" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 3)
    public void RecentTripTest()  {
        try{
            logger=report.startTest("Recent Trip Test");
            if(pastJourneyFunctions.RecentTrip(driver))
            {
                image1=Common.captureScreenshot(driver,"recenttrip_pass");
                logger.log(LogStatus.PASS, "Recent trip is displayed on top"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "recenttrip_fail");
                logger.log(LogStatus.FAIL, "Recent trip is not displayed on top" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 4)
    public void ContentCheckTest()  {
        try{
            logger=report.startTest("Past Journey Screen Content Test");
            if(pastJourneyFunctions.ContentCheck())
            {
                image1=Common.captureScreenshot(driver,"pastcontent_pass");
                logger.log(LogStatus.PASS, "Past journey screen is displayed with correct content"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "pastcontent_fail");
                logger.log(LogStatus.FAIL, "Past journey screen is not displayed with correct content" + logger.addScreenCapture(image1));
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
        AppiumServer.StopAppium();
    }
}
