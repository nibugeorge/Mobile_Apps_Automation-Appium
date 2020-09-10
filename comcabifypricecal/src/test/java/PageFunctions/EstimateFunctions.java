package PageFunctions;

import PageElements.CaptchaObjects;
import PageElements.EstimateObjects;
import PageElements.LoginObjects;
import PageElements.PastJourneyObjects;
import Utils.Common;
import Utils.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

public class EstimateFunctions {
    LoginObjects loginObjects = new LoginObjects();
    CaptchaObjects captchaObjects=new CaptchaObjects();
    EstimateObjects estimateObjects=new EstimateObjects();
    PastJourneyObjects pastJourneyObjects=new PastJourneyObjects();


    public EstimateFunctions(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), loginObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), captchaObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), estimateObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), pastJourneyObjects);
    }

    public boolean CheckCaptcha(String capt) {
        estimateObjects.captcha.sendKeys(capt);
        estimateObjects.estimateButton.click();
        if (Common.isElementPresent(estimateObjects.captchaerror)) {
            return false;
        } else {
            return true;
        }
    }

    public String ReturnEsitmate() {
        return(estimateObjects.price1.getAttribute("text"));
    }

    public boolean GetEsitmateLite(AppiumDriver<MobileElement> driver,String src,String dest,String capt) {
        estimateObjects.source.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(src);
        estimateObjects.dest.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(dest);
        estimateObjects.captcha.sendKeys(capt);
        estimateObjects.estimateButton.click();
        if (!estimateObjects.price1.getAttribute("text").contains("null") && !Common.isElementPresent(estimateObjects.captchaerror)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean GetEsitmateExec(AppiumDriver<MobileElement> driver,String src,String dest,String capt) {
        estimateObjects.source.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(src);
        estimateObjects.dest.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(dest);
        estimateObjects.lite.click();
        estimateObjects.exec.click();
        estimateObjects.captcha.sendKeys(capt);
        estimateObjects.estimateButton.click();
        if (!estimateObjects.price1.getAttribute("text").contains("null") && !Common.isElementPresent(estimateObjects.captchaerror)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean GetEsitmateAll(AppiumDriver<MobileElement> driver,String src,String dest,String capt) {
        estimateObjects.source.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(src);
        estimateObjects.dest.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(dest);
        estimateObjects.exec.click();
        estimateObjects.captcha.sendKeys(capt);
        estimateObjects.estimateButton.click();
        if (Common.isElementPresent(estimateObjects.price2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean RequestCar() {
        if (!estimateObjects.price1.getAttribute("text").contains("null")) {
            estimateObjects.requestButton.click();
            if(Common.isElementPresent(pastJourneyObjects.head)){
                return true;
            }
            else{
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean CheckExecutiveEstimate(String lite,String exec) {
        String value1=lite.replaceAll("€","" );
        String value2=exec.replaceAll("€","" );
        Double dvalue1=Double.parseDouble(value1);
        Double dvalue2=Double.parseDouble(value2);
        Double calEst=dvalue1*0.1+dvalue1;
        BigDecimal bd2 = new BigDecimal(calEst).setScale(3, RoundingMode.HALF_EVEN);
        calEst = bd2.doubleValue();
        if(dvalue2.equals(calEst)){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean DefaultEstimate() {
        if(estimateObjects.price1.getAttribute("text").equals("0")){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean DefaultCarType() {
        if(estimateObjects.lite.getAttribute("checked").equals("true")){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean GetNoCarEsitmate(AppiumDriver<MobileElement> driver,String src,String dest,String capt) {
        estimateObjects.source.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(src);
        estimateObjects.dest.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(dest);
        estimateObjects.lite.click();
        estimateObjects.captcha.sendKeys(capt);
        estimateObjects.estimateButton.click();
        if (estimateObjects.price1.getAttribute("text").contains("null") && Common.isElementPresent(estimateObjects.captchaerror)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean RequestCarWithouEsitmate(AppiumDriver<MobileElement> driver,String src,String dest,String capt) {
        estimateObjects.source.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(src);
        estimateObjects.dest.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(dest);
        estimateObjects.captcha.sendKeys(capt);
        estimateObjects.requestButton.click();
        if (Common.isElementPresent(pastJourneyObjects.head)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean SourceDestCheck(AppiumDriver<MobileElement> driver,String src,String dest,String capt) {
        estimateObjects.source.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(src);
        estimateObjects.dest.click();
        Common.waitForPageToLoad(driver,estimateObjects.point1);
        LocationPick(dest);
        estimateObjects.captcha.sendKeys(capt);
        estimateObjects.estimateButton.click();
        Common.waitForPageToLoad(driver,estimateObjects.price1);
        if(!src.equals(dest)){
            return true;
        }
        else{
            return false;
        }

    }


    public boolean ContentCheck() {
        if(estimateObjects.head.getAttribute("text").equals(Config.ESTIMATE_HEADER)&& estimateObjects.label1.getAttribute("text").equals(Config.ESTIMATE_LABEL1)&&
                estimateObjects.label2.getAttribute("text").equals(Config.ESTIMATE_LABEL2)&&estimateObjects.label3.getAttribute("text").equals(Config.ESTIMATE_LABEL3)&&estimateObjects.label4.getAttribute("text").equals(Config.ESTIMATE_LABEL4)&&
                estimateObjects.label5.getAttribute("text").equals(Config.ESTIMATE_LABEL5)&&estimateObjects.label6.getAttribute("text").equals(Config.ESTIMATE_LABEL6)){
            return true;
        }
        else{
            return false;
        }
    }

    public void LocationPick(String src) {
        switch (src){
            case "Atocha":estimateObjects.point1.click();
                break;
            case "Aeropuerto Madrid Barajas, T4":estimateObjects.point2.click();
                break;
            case "Calle Pradillo, 42":estimateObjects.point3.click();
                break;
            case "Calle Mejia Lequerica, 14":estimateObjects.point4.click();
                break;
            default:estimateObjects.point1.click();
        }
    }

}
