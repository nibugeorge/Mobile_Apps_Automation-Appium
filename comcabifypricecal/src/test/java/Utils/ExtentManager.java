package Utils;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ExtentManager {
    public static Properties prop = new Properties();
    static InputStream input = null;
    static String Path;

    public static ExtentReports Instance() throws Exception
    {
        ExtentReports extent = null;
        input = new FileInputStream(Config.PROP_FILEPATH);
        prop.load(input);
        if (prop.getProperty("platform").equals("ios"))
        {
            Path = Config.IOSREPORT_FILEPATH;
            extent = new ExtentReports(Path,false);
            extent.loadConfig(new File(Config.IOSREPORTCONFIG_FILEPATH));

        }
        else if (prop.getProperty("platform").equals("android"))
        {
            Path = Config.ANDROIDREPORT_FILEPATH;
            extent = new ExtentReports(Path,false);
            extent.loadConfig(new File(Config.ANDROIDREPORTCONFIG_FILEPATH));
        }
        //System.out.println(Path);
        return extent;
    }
}
