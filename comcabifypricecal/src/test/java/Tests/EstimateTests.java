package Tests;

import PageFunctions.CaptchaFunctions;
import PageFunctions.EstimateFunctions;
import PageFunctions.LoginFunctions;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EstimateTests {
    public static AppiumDriver<MobileElement> driver;
    LoginFunctions loginFunctions;
    CaptchaFunctions captchaFunctions;
    EstimateFunctions estimateFunctions;

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
        estimateFunctions=new EstimateFunctions(driver);
        loginFunctions.UserLogin("user@qabify.com","1234Abc");
        cap1=captchaFunctions.GetCaptcha();
        captchaFunctions.EstimateScreen();
    }

    @Test(priority = 1)
    public void ValidCaptchaTest()  {
        try{
            logger=report.startTest("Valid captcha Test");
            if(estimateFunctions.CheckCaptcha(cap1))
            {
                image1=Common.captureScreenshot(driver,"validatecap_pass");
                logger.log(LogStatus.PASS, "Entered captcha is valid"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "validatecap_fail");
                logger.log(LogStatus.FAIL, "Entered captcha is invalid" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "captcha",priority = 2)
    public void InvalidCaptchaTest(String captcha)  {
        try{
            logger=report.startTest("Invalid Captcha Test");
            if(!estimateFunctions.CheckCaptcha(captcha))
            {
                image1=Common.captureScreenshot(driver,"invalidatecap_pass_"+captcha);
                logger.log(LogStatus.PASS, "Captcha cannot be any random number nor empty"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "invalidatecap_fail_"+captcha);
                logger.log(LogStatus.FAIL, "Captcha takes any random number and spaces" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "trip",priority = 3)
    public void GetLiteEstimateTest(String src,String dest)  {
        try{
            logger=report.startTest("Get Lite Estimate Test");
            if(estimateFunctions.GetEsitmateLite(driver,src,dest,cap1))
            {
                image1=Common.captureScreenshot(driver,"estimatelite_pass_"+src+dest);
                logger.log(LogStatus.PASS, "User is able to get an estimate for a lite car"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "estimatelite_fail_"+src+dest);
                logger.log(LogStatus.FAIL, "User is not able to get an estimate for a lite car" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "trip",priority = 4)
    public void GetExecEstimateTest(String src,String dest)  {
        try{
            logger=report.startTest("Get Executive Estimate Test");
            if(estimateFunctions.GetEsitmateExec(driver,src,dest,cap1))
            {
                image1=Common.captureScreenshot(driver,"estimatexec_pass_"+src+dest);
                logger.log(LogStatus.PASS, "User is able to get an estimate for an executive car"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "estimatexec_fail_"+src+dest);
                logger.log(LogStatus.FAIL, "User is not able to get an estimate for an executive car" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "trip",priority = 5)
    public void GetAllEstimateTest(String src,String dest)  {
        try{
            logger=report.startTest("Get All Estimate Test");
            if(estimateFunctions.GetEsitmateAll(driver,src,dest,cap1))
            {
                image1=Common.captureScreenshot(driver,"estimateall_pass_"+src+dest);
                logger.log(LogStatus.PASS, "Estimate is displayed for both car types"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "estimateall_fail_"+src+dest);
                logger.log(LogStatus.FAIL, "Estimate is displayed only for one car type even when both car types are selected" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "trip",priority = 6)
    public void RequestCarLiteTest(String src,String dest)  {
        try{
            logger=report.startTest("Request Car Lite Test");
            estimateFunctions.GetEsitmateLite(driver,src,dest,cap1);
            if(estimateFunctions.RequestCar())
            {
                image1=Common.captureScreenshot(driver,"requestcarlite_pass_"+src+dest);
                logger.log(LogStatus.PASS, "User is able to request for a lite car"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "requestcarlite_fail_"+src+dest);
                logger.log(LogStatus.FAIL, "User is able to request for a lite car" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "trip",priority = 7)
    public void RequestCarExecTest(String src,String dest)  {
        try{
            logger=report.startTest("Request Car Executive Test");
            estimateFunctions.GetEsitmateExec(driver,src,dest,cap1);
            if(estimateFunctions.RequestCar())
            {
                image1=Common.captureScreenshot(driver,"requestcarexec_pass_"+src+dest);
                logger.log(LogStatus.PASS, "User is able to request for an executive car"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "requestcarexec_fail_"+src+dest);
                logger.log(LogStatus.FAIL, "User is not able to request for an executive car" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "trip",priority = 8)
    public void RequestCaAllTest(String src,String dest)  {
        try{
            logger=report.startTest("Request Car All Test");
            estimateFunctions.GetEsitmateAll(driver,src,dest,cap1);
            if(!estimateFunctions.RequestCar())
            {
                image1=Common.captureScreenshot(driver,"requestcarall_pass_"+src+dest);
                logger.log(LogStatus.PASS, "User should be able to request both car types at a time"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "requestcarall_fail_"+src+dest);
                logger.log(LogStatus.FAIL, "User should be able to request only one car type at a time" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "trip",priority = 9)
    public void CheckExecEstimateTest(String src,String dest)  {
        try{
            logger=report.startTest("Check Executive Estimate Test");
            estimateFunctions.GetEsitmateLite(driver,src,dest,cap1);
            String liteEst=estimateFunctions.ReturnEsitmate();
            estimateFunctions.GetEsitmateExec(driver,src,dest,cap1);
            String execEst=estimateFunctions.ReturnEsitmate();
            //logger.log(LogStatus.INFO,"value"+estimateFunctions.checkExecutiveEstimate(driver,liteEst,execEst));
            if(estimateFunctions.CheckExecutiveEstimate(liteEst,execEst))
            {
                image1=Common.captureScreenshot(driver,"execestcheck_pass_"+src+dest);
                logger.log(LogStatus.PASS, "Executive estimate is 10% of Lite Estimate"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "execestcheck_fail_"+src+dest);
                logger.log(LogStatus.FAIL, "Executive estimate is not  10% of Lite Estimate" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 10)
    public void DefaultEstimateTest()  {
        try{
            logger=report.startTest("Default Estimate Test");
            if(estimateFunctions.DefaultEstimate())
            {
                image1=Common.captureScreenshot(driver,"defaultest_pass");
                logger.log(LogStatus.PASS, "Default estimate displayed is zero"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "defaultest_fail");
                logger.log(LogStatus.FAIL, "Default estimate is not displayed as zero" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 11)
    public void DefaultCarTypeTest()  {
        try{
            logger=report.startTest("Default Car Type Test");
            if(estimateFunctions.DefaultCarType())
            {
                image1=Common.captureScreenshot(driver,"defaultcar_pass");
                logger.log(LogStatus.PASS, "Default car type is selected lite"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "defaultcar_fail");
                logger.log(LogStatus.FAIL, "Default car type is not selected as lite" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 13)
    public void GetEstimateNoCarTest()  {
        try{
            logger=report.startTest("Get Estimate Without Selecting Car Test");
            if(estimateFunctions.GetNoCarEsitmate(driver,"Atocha","Calle Pradillo, 42",cap1))
            {
                image1=Common.captureScreenshot(driver,"estimatenocar_pass");
                logger.log(LogStatus.PASS, "Estimate is not calculated when no car type is selected"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "estimatenocar_fail");
                logger.log(LogStatus.FAIL, "Estimate is still calculated when no car type is selected" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 14)
    public void RequestCarWithoutEstimateTest()  {
        try{
            logger=report.startTest("Request With No Estimate Test");
            estimateFunctions.GetEsitmateLite(driver,"Atocha","Calle Pradillo, 42",cap1);
            if(estimateFunctions.RequestCarWithouEsitmate(driver,"Atocha","Calle Mejia Lequerica, 14",cap1))
            {
                image1=Common.captureScreenshot(driver,"carnoestimate_pass");
                logger.log(LogStatus.PASS, "Request car button is not enabled"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "carnoestimate_fail");
                logger.log(LogStatus.FAIL, "Request car button is still enabled without estimating for new trip" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 15)
    public void SameSourceDestTest()  {
        try{
            logger=report.startTest("Same Source & Destination Test");
            if(estimateFunctions.SourceDestCheck(driver,"Atocha","Atocha",cap1))
            {
                image1=Common.captureScreenshot(driver,"sourcedestsame_pass");
                logger.log(LogStatus.PASS, "Error is displayed when source and destination is same"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "sourcedestsame_fail");
                logger.log(LogStatus.FAIL, "No error is displayed saying source and destination is same" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 16)
    public void ContentCheckTest()  {
        try{
            logger=report.startTest("Estimate Screen Content Test");
            if(estimateFunctions.ContentCheck())
            {
                image1=Common.captureScreenshot(driver,"estcontent_pass");
                logger.log(LogStatus.PASS, "Estimate screen is displayed with correct content"+ logger.addScreenCapture(image1));

            }
            else {
                image1 = Common.captureScreenshot(driver, "estcontent_fail");
                logger.log(LogStatus.FAIL, "Estimate screen is not displayed with correct content" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @DataProvider(name="trip")
    public Object[][] data1(){
        Object[][] data1=new Object[3][2];
        data1[0][0]="Atocha";
        data1[0][1]="Aeropuerto Madrid Barajas, T4";
        data1[1][0]="Aeropuerto Madrid Barajas, T4";
        data1[1][1]="Calle Pradillo, 42";
        data1[2][0]="Calle Pradillo, 42";
        data1[2][1]="Calle Mejia Lequerica, 14";
        return data1;
    }

    @DataProvider(name="captcha")
    public Object[] data2(){
        Object[] data2=new Object[2];
        data2[0]="123";
        data2[1]=" ";
        return data2;
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
