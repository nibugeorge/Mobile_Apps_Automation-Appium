package PageFunctions;

import PageElements.CaptchaObjects;
import PageElements.EstimateObjects;
import PageElements.LoginObjects;
import Utils.Common;
import Utils.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CaptchaFunctions {

    LoginObjects loginObjects = new LoginObjects();
    CaptchaObjects captchaObjects=new CaptchaObjects();
    EstimateObjects estimateObjects=new EstimateObjects();

    public CaptchaFunctions(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), loginObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), captchaObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), estimateObjects);
    }

    public boolean CaptchaDisplayed() {
        if (Common.isElementPresent(captchaObjects.captcha)) {
            return true;
        } else {
            return false;
        }
    }

    public String GetCaptcha() {
        return captchaObjects.captcha.getAttribute("text");
    }

    public boolean EstimateScreen() {
        captchaObjects.nextButton.click();
        if (Common.isElementPresent(estimateObjects.head)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean CaptchaFormat(String cap) {
        char[] capChar=cap.toCharArray();
        if(capChar.length==3&&cap.matches(("[0-9]+"))){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean ContentCheck() {
        if(captchaObjects.head.getAttribute("text").equals(Config.CAPTCHA_LABEL)&&captchaObjects.nextButton.getAttribute("text").equals(Config.CAPTCHA_NEXT_BUTTON)){
            return true;
        }
        else{
            return false;
        }
    }

}
