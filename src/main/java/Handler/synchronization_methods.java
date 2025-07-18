package Handler;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class synchronization_methods {
    public static void waitForElementElement(WebDriver driver, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void WaitForWindowHandls(WebDriver driver, int  numberofWindows) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.numberOfWindowsToBe(numberofWindows));
    }
    public static void waitFor_url_containing(WebDriver driver, String Url) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.urlContains(Url));
    }
    public static void waitFor_Element_toBe_clickable(WebDriver driver, By By_locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.elementToBeClickable(By_locator));
    }


    public static void WaitForvisibilityOfElementLocated(WebDriver driver, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public static void WaitForvisibilityOfElementLocatedandtext(WebDriver driver, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,"Sign in"));

    }
     public  static  void Explicit_Wait_Method(WebDriver d, By locator){
         try {
             // Explicitly wait for the element to be present
             WebElement element = new WebDriverWait(d, Duration.ofSeconds(40))
                     .until(ExpectedConditions.presenceOfElementLocated(locator));

             // Now you can interact with the element
             System.out.println(element.isDisplayed());
         } catch (NoSuchElementException e) {
             // Handle the exception or log an error
             e.printStackTrace();
         }
     }
    public static void waitForElementExtra(WebDriver driver, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public static boolean retryingFindClick(WebDriver driver, By by) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch (Exception x) {
            }
            attempts++;
        }
        return result;
    }
}
