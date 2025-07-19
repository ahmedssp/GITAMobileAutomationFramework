# 📱 Appium Mobile Automation Framework

This is a Java-based mobile test automation framework built using:

 Maven Profiles for environment-based configurations


📱 Appium Mobile Automation Framework

This is a Java-based mobile test automation framework designed for testing mobile applications, specifically focusing on flight and hotel booking functionalities. It is built using:





✅ Appium



✅ Java (Maven)



✅ TestNG



✅ Page Object Model (POM)



✅ ExtentReports (with screenshots on failure)



✅ Maven Profiles for environment-based configurations



✅ JSON-based test data

---

## 📁 Project Structure
`````
AAppiumFramework/
├── pom.xml
├── README.md
├── testng.xml

├── test-output/
│   └── screenshots/                    

├── Execution Recording/               
├── Reports/                           

├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── configurations/
│   │   │   │   ├── config.dev.properties
│   │   │   │   ├── config.prod.properties
│   │   │   │   ├── config.qa.properties
│   │   │   │   └── extent-reports-config.json
│   │   │   ├── Handler/
│   │   │   │   ├── alert_handling.java
│   │   │   │   ├── HelperClass.java
│   │   │   │   └── synchronization_methods.java
│   │   │   ├── Pages/
│   │   │   │   ├── Page1.java
│   │   │   │   └── Page2.java
│   │   │   ├── TestData/
│   │   │   │   └── TestData.json
│   │   │   └── utils/
│   │   │       ├── ConfigReader.java
│   │   │       ├── ExtentManager.java
│   │   │       ├── ScreenshotUtil.java
│   │   │       └── testing_methods.java

│   └── test/
│       └── java/
│           ├── Base/
│           │   ├── BaseTest.java
│           │   └── Hellper.java
│           ├── Test/
│           │   ├── Test.java
│           │   └── TestListener.java
`````

🚀 How to Run

✅ Pre-requisites





Java 17+: Ensure JDK 17 or higher is installed and configured in your JAVA_HOME environment variable.



Maven: Install Maven for dependency management and test execution.



Android Studio: Required for Android SDK and emulator setup.



Appium Server: Running at http://localhost:4723. Install via npm (npm install -g appium) or Appium Desktop.



Real Device or Emulator: Configure an Android device/emulator with the app under test installed.



Environment Variables:





ANDROID_HOME: Set to the Android SDK path (e.g., ~/Library/Android/sdk on macOS).



JAVA_HOME: Set to the JDK installation path.



Test Data: Ensure src/main/java/TestData/TestData.json is configured with valid test data for hotel search scenarios.

🛠️ Setup Instructions


Clone the Repository:
```
git clone <repository-url>
cd AppiumFramework
```
Install Dependencies:
```
mvn clean install
```

Start Appium Server:
```
appium
```
Configure Device:

Ensure your Android device/emulator is connected and visible via adb devices.



Update config.<env>.properties with device-specific capabilities (e.g., deviceName, platformVersion, appPackage, appActivity).

▶️ Run Tests

Run with Default (QA) Profile:
```
mvn clean test
```
Run with Specific Environment:
```
mvn clean test -Pdev
mvn clean test -Pprod
```
📋 Test Scenarios





Flight Booking Test (testFlightSearch):





Selects flight options, departure/destination airports, and dates.



Fills out a booking form with user details (name, email, phone, etc.).



Performs swipe and tap actions for navigation.



Verifies success messages and captures screenshots on failure.



Hotel Search Test (testHotelSearch):





Uses JSON test data from TestData.json to select destination and dates.



Navigates hotel selection and verifies search results.



Captures screenshots on failure.

📊 Test Reporting





ExtentReports: HTML reports with test results and screenshots (on failure) are generated in the test-output/ directory.



Report Location: After test execution, open test-output/ExtentReport.html in a browser to view the detailed report.



Screenshots: Captured automatically for failed tests and saved in test-output/screenshots/.



🧪 Writing New Tests





Create Page Objects: Add new page classes under src/test/java/pages/ following the Page Object Model.



Add Test Cases: Create new test classes under src/test/java/tests/ and extend BaseTest.



Update Test Data: Modify src/main/java/TestData/TestData.json for new test scenarios (e.g., hotel search parameters).



Update Configurations: Modify config.<env>.properties for environment-specific settings.



🔧 Troubleshooting





Appium Server Not Running: Ensure the server is started at http://localhost:4723.



Device Not Detected: Run adb devices to verify device connection.



Dependency Issues: Run mvn clean install to resolve missing dependencies.



JSON Parsing Errors: Verify TestData.json is correctly formatted and accessible.



Configuration Errors: Ensure config.<env>.properties matches your device/emulator setup.



📦 Dependencies

The project uses the following key dependencies (defined in pom.xml):





Appium Java Client: io.appium:java-client:9.2.3



Selenium Java: org.seleniumhq.selenium:selenium-java:4.27.0



TestNG: org.testng:testng:7.8.0



ExtentReports: com.aventstack:extentreports:5.1.1



Jackson Databind: com.fasterxml.jackson.core:jackson-databind:2.15.2 (for JSON test data)



Lombok: org.projectlombok:lombok:1.18.30



Apache Commons IO: commons-io:commons-io:2.19.0



📝 Notes



Ensure the app under test is installed on the device/emulator before running tests.



For real devices, enable Developer Options and USB Debugging.



Use Maven profiles (qa, dev, prod) to switch between environments seamlessly.



The TestData.json file drives the hotel search test; ensure it contains valid data for destination, checkInDate, checkOutDate, and resultText.

Execution link : https://drive.google.com/file/d/1TTGIofPccfMmsLTNyPy6Hkw_ens_wHGs/view?usp=sharing

---

## 👨‍💻 Created By

**Ahmed Mostafa Abdelsalame**

---
