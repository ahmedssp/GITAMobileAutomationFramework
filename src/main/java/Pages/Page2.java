package Pages;
import Handler.HelperClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page2 {
    private final AppiumDriver driver;
    private final WebDriverWait wait;



    public Page2(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));
    }
    private String uiSelectorByClassAndIndex(String className, int index) {
        return "new UiSelector().className(\"" + className + "\").instance(" + index + ")";
    }
    private final By resultTextByAccessibilityId = AppiumBy.accessibilityId("أفضل الرحلات التي تناسب");

    private final By resultTextByPartialText = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"الفنادق المتاحة\")");
    private final By bookNowButton = AppiumBy.accessibilityId("احجز الآن");
    private final By cancel=AppiumBy.accessibilityId("الإلغاء");
    private final By emailField = AppiumBy.xpath("//android.widget.EditText[@hint='البريد الإلكتروني']");
    private final By fallbackLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");

    private final By nameField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
    private final By countryCodeView = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(13)");

    private final By saudiOption = AppiumBy.xpath("//android.view.View[@content-desc='966 السعودية']");
    private final By phoneField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)");
    private final By additionalNameField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)");
    private final By shortNameField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
    private final By passengerImageByClassAndIndex = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)\n");
    private final By okButton = AppiumBy.accessibilityId("حسنًا");
    private final By gender = AppiumBy.accessibilityId("ذكر");
    private final By idField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
    private final By nationalityView = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(8)");
    private final By residenceView = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)");
    private final By issueDatePicker = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)");
    private final By issueDate = AppiumBy.accessibilityId("4, الجمعة، ٤ يوليو ٢٠٢٥");
    private final By expiryDatePicker = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
    private final By expiryDate = AppiumBy.accessibilityId("31, الخميس، ٣١ يوليو ٢٠٢٥");
    private final By termsCheckbox = AppiumBy.accessibilityId("أوافق على الشروط والأحكام وسياسة الخصوصية");
    private final By nextButton = AppiumBy.accessibilityId("التالي");
    private final By buttonLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)");

    List<By> locators = List.of(
            resultTextByAccessibilityId,
            resultTextByAccessibilityId,
            resultTextByAccessibilityId

    );
    List<By> locators2 = List.of(
            resultTextByPartialText,
            resultTextByPartialText,
            resultTextByPartialText

    );
    public String getResultText(){
        return HelperClass.getResultText(driver,locators);
    }
    public String getResultText2(){
        return HelperClass.getResultText(driver,locators2);
    }


    public void clickBookNow() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(bookNowButton)).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click Book Now button: " + e.getMessage());
        }
    }
    public void enterName(String name) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        element.click();
        element.clear();
        element.sendKeys(name);
    }

    public void enterEmail(String email) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
            element.click();
            element.clear();
            element.sendKeys(email);
        } catch (TimeoutException e) {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fallbackLocator));
            element.click();
            element.clear();
            element.sendKeys(email);
        }
    }

    public void selectCountryCode(String code) {
        try {
            WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(13)\n")));
            inputField.click();
            WebElement countryItem = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"" + code + "\")")));
            countryItem.click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(countryCodeView)).click();
            wait.until(ExpectedConditions.elementToBeClickable(saudiOption)).click();
        }
    }

    public void enterPhoneNumber(String phone) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(phoneField));
        element.click();
        element.sendKeys(phone);
    }

    public void enterAdditionalName(String name) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(additionalNameField));
        element.click();
        element.sendKeys(name);
    }

    public void enterShortName(String name) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(shortNameField));
        element.click();
        element.sendKeys(name);
    }

    public void selectBirthDate(String Brithday) {

        wait.until(ExpectedConditions.elementToBeClickable(passengerImageByClassAndIndex)).click();

         try {
             wait.until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();

         }catch (Exception e){
             wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
             wait.until(ExpectedConditions.elementToBeClickable(passengerImageByClassAndIndex)).click();
             wait.until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();

         }


        By editTextLocator = AppiumBy.className("android.widget.EditText");
        WebElement el2 = wait.until(ExpectedConditions.elementToBeClickable(editTextLocator));
        el2.click();
        el2.sendKeys(Brithday);

        By okButtonLocator = AppiumBy.accessibilityId("حسنًا");
        WebElement el3 = wait.until(ExpectedConditions.elementToBeClickable(okButtonLocator));
        el3.click();
    }

    public void selectGender() {
        wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
    }

    public void enterIdNumber(String id) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(idField));
        element.click();
        element.sendKeys(id);
        System.out.println("Entered ID number: " + id);
    }

    public void selectNationality(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(nationalityView)).click();
        WebElement countryItem = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"" + country + "\")")));
        countryItem.click();
    }

    public void selectResidenceCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(residenceView)).click();
        WebElement countryItem = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"" + country + "\")")));
        countryItem.click();
    }

    public void selectIssueDate() {
        wait.until(ExpectedConditions.elementToBeClickable(issueDatePicker)).click();
        wait.until(ExpectedConditions.elementToBeClickable(issueDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    public void selectExpiryDate() {
        wait.until(ExpectedConditions.elementToBeClickable(expiryDatePicker)).click();
        wait.until(ExpectedConditions.elementToBeClickable(expiryDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    public void acceptTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public boolean showSuccessMessage(String Messeg) {
        try {
            driver.findElement(AppiumBy.accessibilityId("‪الحقل user type لاغٍ"));
            return true; // Element found
        } catch (Exception e) {
            return false; // Element not found
        }
    }



}