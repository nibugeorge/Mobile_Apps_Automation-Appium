package PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PastJourneyObjects {

    @AndroidFindBy(xpath = "//*[contains(@text,'Past')]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement head;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.cabify.qabify:id/journeyTitle'])[1]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement trip1;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.cabify.qabify:id/journeyPrice'])[1]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement price1;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.cabify.qabify:id/journeyTitle'])[2]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement trip2;

    @AndroidFindBy(id = "(//*[@resource-id='com.cabify.qabify:id/journeyPrice'])[2]")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement price2;
}
