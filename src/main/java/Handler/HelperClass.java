package Handler;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class HelperClass {

    public static String capture(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String dest = "Reports/screenshots/screenshot"+getRandomDateTime()+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        // Read the image file as bytes
        Path path = destination.toPath();
        byte[] imageBytes = Files.readAllBytes(path);

        // Encode the image bytes to base64
        String Screenshot_Image = Base64.getEncoder().encodeToString(imageBytes);

        return Screenshot_Image;
    }
    public static long getRandomDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHmss");
        LocalDateTime now = LocalDateTime.now();
        long genNum;
        genNum= Long.parseLong(dtf.format(now).replaceAll(":","").replaceAll("/",""));
        //   log.info(genNum);
        return genNum;
    }
    public static void WaitForvisibilityOfElementLocated(WebDriver driver, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public static void waitForElementToBeClickable(AppiumDriver driver, int seconds, AppiumBy element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void swipe(AppiumDriver driver, Point start, Point end) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public static void swipeUp(AppiumDriver driver, int startX, int startY, int endX, int endY) {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
        System.out.println("Performed swipe from (" + startX + ", " + startY + ") to (" + endX + ", " + endY + ")");
    }

    public static void performTap(AppiumDriver driver, int x, int y) {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
        System.out.println("Performed tap at (" + x + ", " + y + ")");
    }
//    public static String getResultText(AppiumDriver driver,List locators) {
//
//
//        for (Object locator : locators) {
//            try {
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//                var element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//                String text = element.getText();
//                String contentDesc = element.getAttribute("content-desc");
//                System.out.println("Content-desc attribute: " + contentDesc);
//                if (text != null && !text.isEmpty()) return text;
//                else if (contentDesc != null && !contentDesc.isEmpty()) return contentDesc;
//            } catch (Exception e) {
//                System.out.println("Locator failed: " + locator.toString() + " | Reason: " + e.getMessage());
//            }
//        }
//
//        throw new RuntimeException("Failed to retrieve result text using all locator strategies.");
//    }
    public static String getResultText(AppiumDriver driver, List<By> locators) {
        for (By locator : locators) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

                String text = element.getText();
                String contentDesc = element.getAttribute("content-desc");

                System.out.println("Locator matched: " + locator.toString());
                System.out.println("Text: " + text + ", Content-desc: " + contentDesc);

                if (text != null && !text.isEmpty()) return text;
                if (contentDesc != null && !contentDesc.isEmpty()) return contentDesc;

            } catch (Exception e) {
                System.out.println("Locator failed: " + locator + " | Reason: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for detailed error
            }
        }

        throw new RuntimeException("Failed to retrieve result text using all locator strategies.");
    }
}
