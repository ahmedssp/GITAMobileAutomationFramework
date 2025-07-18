package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import Handler.HelperClass;

import static Handler.HelperClass.swipe;

public class Page1 {
    private final AppiumDriver driver;
    private final WebDriverWait wait;

    public Page1(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private String uiSelectorByClassAndIndex(String className, int index) {
        return "new UiSelector().className(\"" + className + "\").instance(" + index + ")";
    }

    // elements (locators)
    private final By flightOption        = AppiumBy.accessibilityId("طيران");
    private final By departureAirport    = AppiumBy.androidUIAutomator(uiSelectorByClassAndIndex("android.widget.ImageView", 1));
    private final By departureOption     = AppiumBy.androidUIAutomator("new UiSelector().description(\"مطار محمد بن عبدالعزيز\nالمدينة المنورة\n(MED)\")");
    private final By destinationAirport  = AppiumBy.androidUIAutomator(uiSelectorByClassAndIndex("android.widget.ImageView", 3));
    private final By destinationOption   = AppiumBy.androidUIAutomator("new UiSelector().description(\"مطار القاهره الدولي\nالقاهرة\n(CAI)\")");
    private final By departureDateIcon   = AppiumBy.androidUIAutomator(uiSelectorByClassAndIndex("android.widget.ImageView", 4));
    private final By confirmDateButton   = AppiumBy.accessibilityId("حسنًا");
    private final By confirmDateButton3   = AppiumBy.androidUIAutomator("new UiSelector().description(\"تأكيد\")\n");
    private final By dateField = By.className("android.widget.EditText");
    private final By searchButton        = AppiumBy.accessibilityId("بحث");
    private final By firstButton = By.className("android.widget.Button");
    private final By hotelsButton = AppiumBy.accessibilityId("فنادق");
    private final By secondImageView = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");


    public void selectFlightOption() {
        wait.until(ExpectedConditions.elementToBeClickable(flightOption)).click();
    }

    public void selectDepartureAirport() {
        wait.until(ExpectedConditions.presenceOfElementLocated(departureAirport)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(departureOption)).click();
    }

    public void selectDestinationAirport() {
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationAirport)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationOption)).click();
    }

    public void selectDepartureDate(String datefrom,String dateto) {
        wait.until(ExpectedConditions.presenceOfElementLocated(departureDateIcon)).click();

        // Click the first button
        WebElement el5 = wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        el5.click();

        // Click "حسنًا" button
        WebElement el6 = wait.until(ExpectedConditions.elementToBeClickable(confirmDateButton));
        el6.click();

        // Click the same button again (instance 0)
        WebElement el7 = wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        el7.click();

        // Clear and set date in EditText
        WebElement el8 = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        el8.clear();
        el8.sendKeys("٢٠‏/٧‏/٢٠٢٥");

        // Click "حسنًا" again
        WebElement el9 = wait.until(ExpectedConditions.elementToBeClickable(confirmDateButton));
        el9.click();

    }

    public Page2 clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new Page2(driver);
    }

    public void selectHotelSection() {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsButton)).click();
    }

    public void selectDestination(String destination) {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(destination))).click();
    }

    public void swipeToHotelList() {
        swipe(driver,new Point(295, 1296), new Point(314, 421));
    }

    public void selectSecondHotel() {
        wait.until(ExpectedConditions.elementToBeClickable(secondImageView)).click();
    }

    public void selectCheckInDate(String CheckInDate) {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(CheckInDate))).click();
    }

    public void selectCheckOutDate(String CheckOutDate) {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(CheckOutDate))).click();
    }

    public void confirmDateSelection() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDateButton3)).click();
    }

    public void swipeToSearchButton() {
        swipe(driver,new Point(309, 1139), new Point(356, 407));
    }

    public Page2 clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new Page2(driver);
    }


}