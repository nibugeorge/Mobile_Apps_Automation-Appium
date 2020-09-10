package PageFunctions;

import PageElements.CaptchaObjects;
import PageElements.EstimateObjects;
import PageElements.LoginObjects;
import PageElements.PastJourneyObjects;
import Utils.Common;
import Utils.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PastJourneyFunctions {
    int n;
    LoginObjects loginObjects = new LoginObjects();
    CaptchaObjects captchaObjects=new CaptchaObjects();
    EstimateObjects estimateObjects=new EstimateObjects();
    PastJourneyObjects pastJourneyObjects=new PastJourneyObjects();

    public PastJourneyFunctions(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), loginObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), captchaObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), estimateObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), pastJourneyObjects);
    }

    public boolean CheckEstimate(String price) {
        if(pastJourneyObjects.price1.getAttribute("text").equals(price)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean CheckTrip(String src,String dest) {
        if (pastJourneyObjects.trip1.getAttribute("text").contains(src)&&pastJourneyObjects.trip1.getAttribute("text").contains(dest)) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean RecentTrip(AppiumDriver<MobileElement> driver) {
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        estimateObjects.source.click();
        estimateObjects.point1.click();
        estimateObjects.dest.click();
        estimateObjects.point2.click();
        estimateObjects.estimateButton.click();
        Common.waitForPageToLoad(driver,estimateObjects.price1);
        estimateObjects.requestButton.click();
        if (pastJourneyObjects.trip1.getAttribute("text").contains("Atocha")&&pastJourneyObjects.trip1.getAttribute("text").contains("Aeropuerto")) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean ContentCheck() {
        if (pastJourneyObjects.head.getAttribute("text").equals(Config.PAST_LABEL)) {
            return true;
        } else {
            return false;
        }
    }

}
