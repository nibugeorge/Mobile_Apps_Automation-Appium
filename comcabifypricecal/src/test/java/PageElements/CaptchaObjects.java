package PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CaptchaObjects {

    @AndroidFindBy(xpath = "//*[contains(@text,'Remember this code')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement head;

    @AndroidFindBy(id= "com.cabify.qabify:id/captcha_text")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement captcha;

    @AndroidFindBy(id= "com.cabify.qabify:id/captcha_button")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement nextButton;
}
