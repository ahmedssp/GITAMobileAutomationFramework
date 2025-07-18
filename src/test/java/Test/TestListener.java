package Test;
import Base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener  {

    private static WebDriver driver;
    private static ExtentTest logger;

    @Override
    public void onStart(ITestContext context) {
        // Executed before <test> tag of xml file
//        logger = extent.createTest("Test Suite is starting: " + context.getName()+">>>lisiteners");
        System.out.println("Test Suite is starting: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Executed after <test> tag of xml file
//        logger = extent.createTest("Test Suite is ending: " +context.getName()+ ">>>lisiteners");
        System.out.println("Test Suite is ending: " + context.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        // Executed before each @Test method
        System.out.println("Starting test: " + result.getName());
//        logger = extent.createTest("Starting test method: "+result.getMethod().getMethodName()+">>>lisiteners");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            BaseTest.reporter("pass", "Test passed successfully");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            BaseTest.reporter("fail", "Test failed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            BaseTest.reporter("info", "Test skipped");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // Not implemented
    }
}
