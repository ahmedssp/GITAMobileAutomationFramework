package Test;
import Base.BaseTest;
import Pages.Page2;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.IOException;
import static Handler.HelperClass.performTap;
import static Handler.HelperClass.swipeUp;
import static utils.ScreenshotUtil.takeScreenshot;
import static utils.testing_methods.getCurrentMethodName;

public class Test2 extends BaseTest {
    private JsonNode testData;
    public Test2() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            testData = mapper.readTree(new File("src/main/java/TestData/TestData.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFlightSearch() {
        test = extent.createTest("Flight Booking Test");
        logger = extent.createTest(getCurrentMethodName());
        SoftAssert Assert = new SoftAssert();

        logger.info("selectFlightOption");
        p1.selectFlightOption();
        test.pass("selectFlightOption");

        logger.info("selectDepartureAirport");
        p1.selectDepartureAirport();
        test.pass("selectDepartureAirport");

        logger.info("selectDestinationAirport");
        p1.selectDestinationAirport();
        test.pass("selectDestinationAirport");

        logger.info("selectDepartureDate");
        p1.selectDepartureDate("19, الجمعة، ١٨ يوليو ٢٠٢٥","20, الجمعة، ١٨ يوليو ٢٠٢٥");
        test.pass("selectDepartureDate");

        logger.info("clickSearchButton");
        Page2 P2 =p1.clickSearchButton();

        test.pass("clickSearchButton");

        logger.info("clickSearchButton");
        Assert.assertTrue(P2.getResultText().contains("أفضل"), "Expected result text to contain: 'أفضل الرحلات التي تناسب'");
        test.pass("clickSearchButton");

        logger.info("Book_now");
        P2.clickBookNow();
        test.pass("Book_now");

        try {
            logger.info("Start fill second form");
            P2.enterName("ahmed Mostafa");
            swipeUp(driver,353, 729, 367, 494);
            P2.enterEmail("ahmedmostafa@gmial.com");
            swipeUp(driver,365, 707, 365, 494);
            P2.selectCountryCode("966");
            P2.enterPhoneNumber("55008765");
            swipeUp(driver,337, 670, 337, 525);
            swipeUp(driver,334, 987, 323, 609);
            P2.enterAdditionalName("ahmed");
            P2.enterShortName("mostafa");
            swipeUp(driver,334, 987, 323, 609);
            performTap(driver,474, 749);
            P2.selectBirthDate("١٩‏/٧‏/٢٠٠٠");
            P2.selectGender();
            P2.enterIdNumber("098765432123");
            swipeUp(driver,465, 975, 467, 568);
            P2.selectNationality("Saudi");
            P2.selectResidenceCountry("Saudi");
            P2.selectIssueDate();
            P2.selectExpiryDate();
            P2.acceptTerms();
            P2.clickNext();
            Assert.assertTrue(P2.showSuccessMessage("success"), "Expected result text to contain: 'أفضل الرحلات التي تناسب'");
            test.pass("testFlightSearch");
        } catch (Exception e) {
            takeScreenshot(driver,"testFlightSearch");
            test.fail("tst fail testFlightSearch");
            throw e;
        }

        Assert.assertAll();

    }
    @Test
    public void testHotelSearch() {
        JsonNode hotelData = testData.get("hotelSearch");

        try {
            logger.info("Start testHotelSearch");
            p1.selectHotelSection();
            p1.selectDestination(hotelData.get("destination").textValue());
            p1.swipeToHotelList();
            p1.selectSecondHotel();
            p1.selectCheckInDate(hotelData.get("checkInDate").textValue());
            p1.selectCheckOutDate(hotelData.get("checkOutDate").textValue());
            p1.confirmDateSelection();
            p1.swipeToSearchButton();
            Page2 P2 = p1.clickSearch();
            logger.info("clickSearchButton");
            Assert.assertTrue(P2.getResultText2().contains(hotelData.get("resultText").textValue()),
                    "Expected result text to contain: '" + hotelData.get("resultText").textValue() + "'");
            test.pass("clickSearchButton");
        } catch (Exception e) {
            test.fail("tst fail");
            takeScreenshot(driver, "testHotelSearch");
            throw e;
        }
}
}

