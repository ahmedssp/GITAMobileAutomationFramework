package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtil {

    public static String takeScreenshot(AppiumDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
            File dest = new File(path);
            dest.getParentFile().mkdirs(); // create folder if missing
            FileUtils.copyFile(src, dest);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
