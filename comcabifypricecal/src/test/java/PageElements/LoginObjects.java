package PageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginObjects {

    @AndroidFindBy(xpath = "//*[@text='QAbify']")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement head;

    @AndroidFindBy(id = "com.cabify.qabify:id/user_name_edit_text")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement username;

    @AndroidFindBy(id = "com.cabify.qabify:id/password_edit_text")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement password;

    @AndroidFindBy(id = "com.cabify.qabify:id/login_button")
    @iOSFindBy(xpath = "//*[contains(@value,'')]")
    public MobileElement loginButton;

}
