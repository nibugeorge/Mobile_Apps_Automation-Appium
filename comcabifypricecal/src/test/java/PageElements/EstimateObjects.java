package PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class EstimateObjects {
    @AndroidFindBy(xpath = "//*[contains(@text,'Choose your journey')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement head;

    @AndroidFindBy(id= "com.cabify.qabify:id/pick_up_point")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement source;

    @AndroidFindBy(xpath= "//*[contains(@text,'Atocha')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement point1;

    @AndroidFindBy(xpath= "//*[contains(@text,'Aeropuerto')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement point2;

    @AndroidFindBy(xpath= "//*[contains(@text,'Pradillo')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement point3;

    @AndroidFindBy(xpath= "//*[contains(@text,'Lequerica')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement point4;

    @AndroidFindBy(id= "com.cabify.qabify:id/drop_off_point")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement dest;

    @AndroidFindBy(id= "com.cabify.qabify:id/liteCheckBox")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement lite;

    @AndroidFindBy(id= "com.cabify.qabify:id/executiveCheckBox")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement exec;

    @AndroidFindBy(id= "com.cabify.qabify:id/captcha_text")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement captcha;

    @AndroidFindBy(id= "android:id/message")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement captchaerror;

    @AndroidFindBy(xpath= "(//*[@resource-id='com.cabify.qabify:id/price_text'])[1]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement price1;

    @AndroidFindBy(xpath= "(//*[@resource-id='com.cabify.qabify:id/price_text'])[2]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement price2;

    @AndroidFindBy(id= "com.cabify.qabify:id/estimate_button")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement estimateButton;

    @AndroidFindBy(id= "com.cabify.qabify:id/request_button")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement requestButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'origin and destination')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement label1;

    @AndroidFindBy(xpath = "//*[contains(@text,'Pick')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement label2;

    @AndroidFindBy(xpath = "//*[contains(@text,'Drop')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement label3;

    @AndroidFindBy(xpath = "//*[contains(@text,'type of car')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement label4;

    @AndroidFindBy(xpath = "//*[contains(@text,'Type the captcha')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement label5;

    @AndroidFindBy(xpath = "//*[contains(@text,'Estimated price')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement label6;

}
