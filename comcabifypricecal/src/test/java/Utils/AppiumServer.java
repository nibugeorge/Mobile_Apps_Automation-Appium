package Utils;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AppiumServer {
    static AppiumDriverLocalService service;

    public static void StartAppium() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    public static void StopAppium() {
        if (service != null) {
            service.stop();
        }
    }
}
