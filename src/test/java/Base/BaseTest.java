package Base;

import Pages.Page1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;

import static Handler.HelperClass.capture;

public class BaseTest {
    protected static AppiumDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    public Page1 p1;
    public static ExtentTest logger;



//    @BeforeSuite
//    public void setUpSuite() throws IOException {
//        extent = new ExtentReports();
//
//        logger = extent.createTest("Test Suite is started");
//        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/extent-report.html");
//        spark.loadJSONConfig(new File("src/main/java/configurations/extent-reports-config.json"));
//        extent.attachReporter(spark);
//
//    }
@BeforeSuite
public void setUpSuite() throws IOException {
    extent = new ExtentReports();
    logger = extent.createTest("Test Suite is started");
    ExtentSparkReporter spark = new ExtentSparkReporter("Reports/extent-report.html");
    spark.loadJSONConfig(new File("src/main/java/configurations/extent-reports-config.json"));
    extent.attachReporter(spark);

    // Initialize Appium driver temporarily to terminate the app if running
    try {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(ConfigReader.get("platformName"))
                .setDeviceName(ConfigReader.get("deviceName"))
                .setAutomationName(ConfigReader.get("automationName"))
                .setUdid(ConfigReader.get("udid"))
                .setAppPackage(ConfigReader.get("appPackage"))
                .setAppActivity(ConfigReader.get("appActivity"))
                .setNoReset(true); // Avoid resetting app state for this check

        driver = new AppiumDriver(new URL(ConfigReader.get("appiumServerURL")), options);
        // Terminate the app if it is already running
        if (driver instanceof io.appium.java_client.InteractsWithApps) {
            ((io.appium.java_client.InteractsWithApps) driver).terminateApp(ConfigReader.get("appPackage"));
            logger.info("Terminated the app if it was already open.");
        } else {
            logger.warning("Driver does not support app termination.");
        }
        driver.quit(); // Close the temporary driver
        driver = null; // Ensure driver is null before tests start
    } catch (Exception e) {
        logger.warning("Could not terminate the app: " + e.getMessage());
    }
}
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(ConfigReader.get("platformName"))
                .setDeviceName(ConfigReader.get("deviceName"))
                .setAutomationName(ConfigReader.get("automationName"))
                .setUdid(ConfigReader.get("udid"))
                .setAppPackage(ConfigReader.get("appPackage"))
                .setAppActivity(ConfigReader.get("appActivity"))
                .setIgnoreHiddenApiPolicyError(Boolean.parseBoolean(ConfigReader.get("ignoreHiddenApiPolicyError")))
                .setEnsureWebviewsHavePages(Boolean.parseBoolean(ConfigReader.get("ensureWebviewsHavePages")))
                .setNativeWebScreenshot(Boolean.parseBoolean(ConfigReader.get("nativeWebScreenshot")))
                .setNewCommandTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.get("newCommandTimeout"))))
                .setNoReset(Boolean.parseBoolean(ConfigReader.get("noReset")));

        driver = new AppiumDriver(new URL(ConfigReader.get("appiumServerURL")), options);
        p1=new Page1(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            String directoryPath = "Reports/failed tests screenshot/";

            // Create directory if it does not exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                boolean dirCreated = directory.mkdirs();
                if (!dirCreated) {
                    System.out.println("Failed to create directory for screenshots.");
                    // You can choose to throw an exception or handle the failure in another way
                    return;
                }
            }

            // Move the screenshot to the directory
            try {
                Files.move(screenshot.toPath(), new File(directoryPath + result.getName() + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterSuite
    public void tearDownSuite() throws IOException {
        extent.flush();
        // Desktop.getDesktop().open(new File("Reports/extent-report.html"));
    }

    public static void reporter(String status, String stepDetail) throws InterruptedException {
        //ExtentTest logger = null;
        Thread.sleep(1000);
        String base64Screenshot;
        try {
            base64Screenshot = capture(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (status.equalsIgnoreCase("pass")) {
            logger.pass(stepDetail, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else if (status.equalsIgnoreCase("fail")) {
            logger.fail(stepDetail, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else if (status.equalsIgnoreCase("info")) {
            logger.info(stepDetail);
        } else if (status.equalsIgnoreCase("Warning")) {
            logger.warning(stepDetail);
        }
    }
}

