package Base;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Base.BaseTest.driver;

public class HELPPER {
    public void Waite(int ofSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ofSeconds));
    }
}
