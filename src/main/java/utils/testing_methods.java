package utils;

//import static Listeners.testNg_listeners_simple.PassMessege;
//import static Listeners.testNg_listeners_simple.failledMessege;

/**
 * @param
 * @return,
 * @see. this function used to select drop down list by
 * 1- click on list filed what ever if it is dynamic or static
 * 2-get list of elements and loop throw them
 * kye benefit is what ever  the visible link text is large we moderate it and remover spaces and so on ..;
 */
public class testing_methods {
//    public static void Switch_Selector(WebDriver driver, By locator_clicklist, By locatorListelements, String SearchInputWord) {
//        try {
//            WaitForvisibilityOfElementLocated(driver, locator_clicklist);
//            driver.findElement(locator_clicklist).click();
//            for (int x = 0; x < driver.findElements(locatorListelements).size(); x++) {
//                if (driver.findElements(locatorListelements).get(x).getText().toLowerCase().equals(SearchInputWord)) {
//                    System.out.println(driver.findElements(locatorListelements).get(x).getText().toLowerCase());
//                    driver.findElements(locatorListelements).get(x).click();
//                    break;
//                }
//            }
//            Reporter.log(new Object() {}.getClass().getEnclosingMethod().getName() + PassMessege);
//        } catch (Exception E) {
//            Reporter.log(new Object() {}.getClass().getEnclosingMethod().getName() + failledMessege);
//            throw E;
//        }
//    }
//    public static void Switch_Selector2(WebDriver driver, By locator_clicklist, By locatorListelements, String SearchInputWord) {
//        try {
//            WaitForvisibilityOfElementLocated(driver, locator_clicklist);
//            driver.findElement(locator_clicklist).click();
//            for (int x = 0; x < driver.findElements(locatorListelements).size(); x++) {
//                if (driver.findElements(locatorListelements).get(x).getText().toLowerCase().contains(SearchInputWord)) {
//                    System.out.println(driver.findElements(locatorListelements).get(x).getText().toLowerCase());
//                    driver.findElements(locatorListelements).get(x).click();
//                    break;
//                }
//            }
//
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + PassMessege);
//        } catch (Exception E) {
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + failledMessege);
//            throw E;
//        }
//    }
//    public static void Switch_Selector_all(WebDriver driver, By locator_clicklist, By locatorListelements) {
//        try {
//            WaitForvisibilityOfElementLocated(driver, locator_clicklist);
//            System.out.println(driver.findElements(locatorListelements).size());
//
//            driver.findElement(locator_clicklist).click();
//            for (int x = 0; x < driver.findElements(locatorListelements).size(); x++) {
//                driver.findElements(locatorListelements).get(x).click();
//                driver.findElement(locator_clicklist).click();
//
//            }
//
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + PassMessege);
//        } catch (Exception E) {
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + failledMessege);
//            throw E;
//        }
//    }

//    public void NonInput_method(WebDriver d, By locator) {
//        try {
//            WaitForvisibilityOfElementLocated(d, locator);
//            d.findElement(locator).click();
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + PassMessege);
//        } catch (Exception e) {
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + failledMessege);
//        }
//
//    }
//
//    public void SendTxt_method(WebDriver d, By locator, String inputTxt) {
//        try {
//            WaitForvisibilityOfElementLocated(d, locator);
//            d.findElement(locator).sendKeys(inputTxt);
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + PassMessege + "|| Data: " + inputTxt);
//        } catch (Exception e) {
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + failledMessege + "|| Data: " + inputTxt);
//        }
//
//    }
//    public static boolean getcurrenturl_valid(WebDriver d, String messege) {
//
//
//        try {
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + PassMessege);
//            return d.getCurrentUrl().toLowerCase().contains(messege);
//
//        }catch (Exception e){
//            Reporter.log(new Object() {
//            }.getClass().getEnclosingMethod().getName() + failledMessege);
//            throw e;
//        }
//
//    }
    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}
