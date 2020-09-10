package Utils;

public class Config {

    //Appium
    public static final String APPIUMJS_FILEPATH = "//usr//local//lib//node_modules//appium//build//lib//main.js";
    public static final String PROP_FILEPATH = "./Property/platform.properties";

    //Screenshot
    public static final String SCREENSHOTS_FILEPATH = "./Screenshots/";

    //Reporting
    public static final String IOSREPORT_FILEPATH = "./Reports/IosSanityReport.html";
    public static final String IOSREPORTCONFIG_FILEPATH = "./src/main/resources/extent-iosconfig.xml";
    public static final String ANDROIDREPORT_FILEPATH = "./Reports/AndroidSanityReport.html";
    public static final String ANDROIDREPORTCONFIG_FILEPATH = "./src/main/resources/extent-androidconfig.xml";

    //App locations
    public static final String ANDROID_APP_FILEPATH = "./src/main/resources/qabify2019.apk";
    public static final String IOS_APP_FILEPATH = "../../platforms/ios/build/Emulator/qabify2019.app";

    //Capabilities
    public static final String DEVICE_NAME_AND = "Pixel3";
    public static final String APP_PACKAGE = "com.cabify.qabify";
    public static final String APP_ACTIVITY = "com.cabify.qabify.MainActivity";
    public static final String PLATFORM_NAME_AND = "Android";
    public static final String PLATFORM_VERSION_AND = "9.0";
    public static final String LANGUAGE = "en";


    public static final String DEVICE_NAME_IOS = "iPhone 6";
    public static final String PLATFORM_NAME_IOS = "iOS";
    public static final String PLATFORM_VERSION_IOS = "10.2";
    public static final String UDID = "A7375FA22F454C438BABC35C49D20CDE";
    public static final String BUNDLEID = "com.example.test";
    public static final String AUTOMATION_NAME = "XCUITest";

    public static final String APPIUMSERVER_URL = "http://127.0.0.1:4723/wd/hub";

    //Login screen contents
    public static final String LOGIN_HEADER = "QAbify";
    public static final String LOGIN_USERNAME = "Username";
    public static final String LOGIN_PASSWORD = "Password";
    public static final String LOGIN_BUTTON = "LOGIN";

    //Captcha screen contents
    public static final String CAPTCHA_LABEL = "Remember this code for requesting a Taxi";
    public static final String CAPTCHA_NEXT_BUTTON = "NEXT";

    //Estimate screen contents
    public static final String ESTIMATE_HEADER = "Choose your journey settings";
    public static final String ESTIMATE_LABEL1 = "Select your origin and destination:";
    public static final String ESTIMATE_LABEL2 = "Pick up point:";
    public static final String ESTIMATE_LABEL3 = "Drop off point:";
    public static final String ESTIMATE_LABEL4 = "Choose your type of car:";
    public static final String ESTIMATE_LABEL5 = "Type the captcha of the previous screen:";
    public static final String ESTIMATE_LABEL6 = "Estimated price:";

    //Past journey screen contents
    public static final String PAST_LABEL = "Past Journeys";


}
