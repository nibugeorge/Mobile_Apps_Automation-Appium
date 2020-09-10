package PageFunctions;

import PageElements.CaptchaObjects;
import PageElements.LoginObjects;
import Utils.Common;
import Utils.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginFunctions {
    int n;
    LoginObjects loginObjects = new LoginObjects();
    CaptchaObjects captchaObjects=new CaptchaObjects();

    public LoginFunctions(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), loginObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), captchaObjects);
    }

    public int UserLogin(String user,String pass) {
        //Utils.waitForPageToLoad(driver, accountsPageObjects.head);
        loginObjects.username.sendKeys(user);
        loginObjects.password.sendKeys(pass);
        loginObjects.loginButton.click();
        if (Common.isElementPresent(captchaObjects.head)) {
            n = 1;
        } else {
            n = 0;
        }
        return n;
    }

    public boolean LoginButton() {
        //Utils.waitForPageToLoad(driver, accountsPageObjects.head);
        if (loginObjects.loginButton.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PassField(String pass) {
        loginObjects.password.sendKeys(pass);

        if (loginObjects.password.getAttribute("text").contains("*")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean BackNavigation(AppiumDriver<MobileElement> driver,String user,String pass) {
        loginObjects.username.sendKeys(user);
        loginObjects.password.sendKeys(pass);
        loginObjects.loginButton.click();
        Common.waitForPageToLoad(driver,captchaObjects.head);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        if (!Common.isElementPresent(loginObjects.head)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean RelaunchApp(AppiumDriver<MobileElement> driver,String user,String pass) {
        loginObjects.username.sendKeys(user);
        loginObjects.password.sendKeys(pass);
        loginObjects.loginButton.click();
        Common.waitForPageToLoad(driver,captchaObjects.head);
        driver.closeApp();
        driver.launchApp();
        if (!Common.isElementPresent(loginObjects.head)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ContentCheck() {
        if(loginObjects.head.getAttribute("text").equals(Config.LOGIN_HEADER)&&loginObjects.username.getAttribute("text").equals(Config.LOGIN_USERNAME)&&
                loginObjects.password.getAttribute("text").equals(Config.LOGIN_PASSWORD)&&loginObjects.loginButton.getAttribute("text").equals(Config.LOGIN_BUTTON)){
            return true;
        }
        else{
            return false;
        }
    }




}
