//package Pages;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.AppiumDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Pause;
//import org.openqa.selenium.interactions.PointerInput;
//import org.openqa.selenium.interactions.Sequence;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.List;
//
//
//public class Page3 {
//    private final AppiumDriver driver;
//    private final WebDriverWait wait;
//
//    // Constructor
//    public Page2(AppiumDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));
//    }
//
//    // Helper method to generate dynamic UISelector strings
//    private String uiSelectorByClassAndIndex(String className, int index) {
//        return "new UiSelector().className(\"" + className + "\").instance(" + index + ")";
//    }
//
//    // UI elements (locators) for the text "أفضل الرحلات التي تناسب"
//    private final By resultTextByAccessibilityId = AppiumBy.accessibilityId("أفضل الرحلات التي تناسب");
//    private final By resultTextByText = AppiumBy.androidUIAutomator("new UiSelector().text(\"أفضل الرحلات التي تناسب\")");
//    private final By resultTextByPartialText = AppiumBy.androidUIAutomator("new UiSelector().textContains(\"أفضل الرحلات\")");
//    private final By resultTextByXPath = AppiumBy.xpath("//android.view.View[@text='أفضل الرحلات التي تناسب']");
//    private final By resultTextByClassAndIndex = AppiumBy.androidUIAutomator(uiSelectorByClassAndIndex("android.view.View", 1));
//    private final By bookNowButton = AppiumBy.accessibilityId("احجز الآن");
//
//
//    private final By fullNameField = AppiumBy.xpath("//android.widget.EditText[@hint='الاسم بالكامل']");
//    private final By emailField = AppiumBy.xpath("//android.widget.EditText[@hint='البريد الإلكتروني']");
//    private final By phoneNumberField = AppiumBy.xpath("//android.widget.EditText[@hint='رقم الهاتف']");
//    private final By countryCodeField = AppiumBy.accessibilityId("كود الدولة");
//
//    // Element locators
//    private final By nameField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)");
//    private final By countryCodeView = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(13)");
//
//    // Locator declarations (should be at the class level)
//    private final By saudiOption = AppiumBy.xpath("//android.view.View[@content-desc='966 السعودية']");
//
//    private final By phoneField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)");
//    private final By additionalNameField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)");
//    private final By shortNameField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)");
//    private final By passengerImageByClassAndIndex = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)\n");
//    private final By year2002 = AppiumBy.accessibilityId("اختيار العام");
//    private final By birthDate = AppiumBy.accessibilityId("16, الثلاثاء، ١٦ يوليو ٢٠٠٢");
//    private final By okButton = AppiumBy.accessibilityId("حسنًا");
//    private final By gender = AppiumBy.accessibilityId("ذكر");
//    private final By idField = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
//    private final By nationalityView = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(8)");
//    private final By residenceView = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)");
//    private final By saudiCountry = AppiumBy.androidUIAutomator("new UiSelector().description(\"السعودية\\nSaudi Arabia\")");
//    private final By issueDatePicker = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)");
//    private final By issueDate = AppiumBy.accessibilityId("4, الجمعة، ٤ يوليو ٢٠٢٥");
//    private final By expiryDatePicker = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
//    private final By expiryDate = AppiumBy.accessibilityId("31, الخميس، ٣١ يوليو ٢٠٢٥");
//    private final By termsCheckbox = AppiumBy.accessibilityId("أوافق على الشروط والأحكام وسياسة الخصوصية");
//    private final By nextButton = AppiumBy.accessibilityId("التالي");
//
//
//    // Scroll to element if not visible
//    public void scrollToResultText() {
//        try {
//            driver.findElement(AppiumBy.androidUIAutomator(
//                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
//                            "new UiSelector().textContains(\"أفضل الرحلات\"))"));
//        } catch (Exception e) {
//            System.out.println("Failed to scroll to element: " + e.getMessage());
//        }
//    }
//
//    // Method to get full text using different locators
//    public String getResultText(String locatorType) {
//        By locator;
//        switch (locatorType.toLowerCase()) {
//            case "accessibilityid":
//                locator = resultTextByAccessibilityId;
//                break;
//            case "text":
//                locator = resultTextByText;
//                break;
//            case "partialtext":
//                locator = resultTextByPartialText;
//                break;
//            case "xpath":
//                locator = resultTextByXPath;
//                break;
//            case "classandindex":
//                locator = resultTextByClassAndIndex;
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
//        }
//
//        try {
//            scrollToResultText(); // Scroll to ensure visibility
//            var element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//            String text = element.getText();
//            String contentDesc = element.getAttribute("content-desc");
//
//            return text != null && !text.isEmpty() ? text : contentDesc;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to retrieve result text with " + locatorType + ": " + e.getMessage());
//        }
//    }
//    public String getResultText() {
//        // Define locators to try in order
//        List<By> locators = List.of(
//                resultTextByAccessibilityId ,
//               resultTextByAccessibilityId,
//                resultTextByAccessibilityId
////                resultTextByXPath,
////                resultTextByClassAndIndex
//        );
//
//        for (By locator : locators) {
//            try {
//                WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(100));
//                var element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//                String text = element.getText();
//                String contentDesc = element.getAttribute("content-desc");
//                System.out.println("Content-desc attribute: " + contentDesc);
//
//                // Return first non-empty value
//                if (text != null && !text.isEmpty()) {
//                    return text;
//                } else if (contentDesc != null && !contentDesc.isEmpty()) {
//                    return contentDesc;
//                }
//            } catch (Exception e) {
//                System.out.println("Locator failed: " + locator.toString() + " | Reason: " + e.getMessage());
//                // Try the next locator
//            }
//        }
//
//        throw new RuntimeException("Failed to retrieve result text using all locator strategies.");
//    }
//    // Method to get partial text (e.g., "أفضل الرحلات")
//    public String getPartialResultText() {
//        try {
//            scrollToResultText();
//            var element = wait.until(ExpectedConditions.visibilityOfElementLocated(resultTextByPartialText));
//            String text = element.getText();
//            System.out.println("Partial text retrieved: " + text);
//            return text;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to retrieve partial result text: " + e.getMessage());
//        }
//    }
//
//    // Method to click the Book Now button
//    public void clickBookNow() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(bookNowButton)).click();
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to click Book Now button: " + e.getMessage());
//        }
//    }
//
//
////________________________________________________________________________
//
//
//
//    public void enterName(String name) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(nameField));
//        element.click();
//        element.clear(); // Clear any existing text
//        element.sendKeys(name);
//        System.out.println("Entered name: " + name);
//    }
//
//    public void enterEmail(String email) {
//        try {
//            System.out.println("emial start method ");
//            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
//            element.click();
//            System.out.println("emial  clicked failed  ");
//
//            element.clear();
//            System.out.println("emial  clear failed  ");
//
//            element.sendKeys(email);
//            System.out.println("emial  send  ");
//
//            System.out.println("Entered email__firest tray email send successfully : " + email);
//        } catch (TimeoutException e) {
//            System.err.println("Email field not found with primary locator. Falling back to instance-based locator.");
//            By fallbackLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fallbackLocator));
//            element.click();
//            element.clear();
//            element.sendKeys(email);
//            System.out.println("Entered email using fallback locator: " + email);
//        }
//    }
//
//    public void selectCountryCode(String code ) {
//       try {
//
//           WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(
//                   AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(13)\n")));
//           inputField.click();
////           inputField.sendKeys(code );
//
//           WebElement countryItem = wait.until(ExpectedConditions.presenceOfElementLocated(
//                   AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\""+code+"\")")
//           ));
//           countryItem.click();
//
//       }catch (Exception e){
////
//           wait.until(ExpectedConditions.elementToBeClickable(countryCodeView)).click();
//           wait.until(ExpectedConditions.elementToBeClickable(saudiOption)).click();
//    }
//    }
//
//    public void enterPhoneNumber(String phone) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(phoneField));
//        element.click();
//        element.sendKeys(phone);
//    }
//
//    public void enterAdditionalName(String name) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(additionalNameField));
//        element.click();
//        element.sendKeys(name);
//    }
//
//    public void enterShortName(String name) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(shortNameField));
//        element.click();
//        element.sendKeys(name);
//    }
//
//    public void selectBirthDate(String Brithday) {
//        wait.until(ExpectedConditions.elementToBeClickable(passengerImageByClassAndIndex)).click();
//        System.out.println("click birthday filed");
//
//            // Wait and click the first button (instance 0 of android.widget.Button)
//            By buttonLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)");
//            WebElement el1 = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
//            el1.click();
//
//            // Wait and interact with the EditText
//            By editTextLocator = AppiumBy.className("android.widget.EditText");
//            WebElement el2 = wait.until(ExpectedConditions.elementToBeClickable(editTextLocator));
//            el2.click();
//            el2.sendKeys(Brithday);
//
//            // Wait and click the confirmation button with accessibility ID "حسنًا"
//            By okButtonLocator = AppiumBy.accessibilityId("حسنًا");
//            WebElement el3 = wait.until(ExpectedConditions.elementToBeClickable(okButtonLocator));
//            el3.click();
//    }
//
//    public void selectGender() {
//        wait.until(ExpectedConditions.elementToBeClickable(gender)).click();
//    }
//
//    public void enterIdNumber(String id) {
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(idField));
//        element.click();
////        element.clear();
//        element.sendKeys(id);
//        System.out.println("Entered ID number: " + id);
//    }
//
//    public void selectNationality(String country) {
//        wait.until(ExpectedConditions.elementToBeClickable(nationalityView)).click();
//
//        WebElement countryItem = wait.until(
//                ExpectedConditions.presenceOfElementLocated(
//                        AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\""+country+"\")")
//                )
//        );
//        countryItem.click();
//    }
//
//    public void selectResidenceCountry(String country) {
//        wait.until(ExpectedConditions.elementToBeClickable(residenceView)).click();
//        WebElement countryItem = wait.until(
//                ExpectedConditions.presenceOfElementLocated(
//                        AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\""+country+"\")")
//                )
//        );
//        countryItem.click();
//    }
//
//    public void selectIssueDate() {
//        wait.until(ExpectedConditions.elementToBeClickable(issueDatePicker)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(issueDate)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
//    }
//
//    public void selectExpiryDate() {
//        wait.until(ExpectedConditions.elementToBeClickable(expiryDatePicker)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(expiryDate)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
//    }
//
//    public void acceptTerms() {
//        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
//    }
//
//    public void clickNext() {
//        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
//    }
//
//    public void swipeUp(int startX, int startY, int endX, int endY) {
//        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        var swipe = new Sequence(finger, 1);
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), startX, startY));
//        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                PointerInput.Origin.viewport(), endX, endY));
//        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(swipe));
//        System.out.println("Performed swipe from (" + startX + ", " + startY + ") to (" + endX + ", " + endY + ")");
//    }
//
//    public void performTap(int x, int y) {
//        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        var tap = new Sequence(finger, 1);
//
//        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), x, y));
//        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        tap.addAction(new Pause(finger, Duration.ofMillis(50))); // Correct wait here
//        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(tap));
//        System.out.println("Performed tap at (" + x + ", " + y + ")");
//    }
//
//    public String ShowSuccessMessage() {
//
//       return driver.findElement( AppiumBy.accessibilityId("‪الحقل user type لاغٍ")).getText();
//
//    }
//}
//
