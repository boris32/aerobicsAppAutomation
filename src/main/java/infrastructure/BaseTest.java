package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Boris on 6/21/2018.
 */
public class BaseTest {

    protected AppiumDriver<MobileElement> driver;
    protected TestCasePriority priority;

    @BeforeTest
    public void setupTest() throws MalformedURLException {

        //Set desired capabilities:
        DesiredCapabilities ds = new DesiredCapabilities();

        ds.setCapability("deviceName","Android");
        ds.setCapability("platformName", "Android");
        ds.setCapability("appPackage", "com.example.boris.myandroidapp");
        ds.setCapability("appActivity", "com.example.boris.myandroidapp.MainActivity");
        //Reporter.log("Desired capabilities are now set.");

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), ds);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Reporter.log("Driver configured.");
    }

    @AfterTest
    public void wrapUp() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {

        Reporter.log("</table>");
        ReportingUtilities.geenerateResultsTable();

    }





}
