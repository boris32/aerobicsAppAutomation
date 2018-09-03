package tests;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by Boris on 6/24/2018.
 */
public class LayoutTest extends BaseTest {


    public LayoutTest () {
    }

    @Test
    public void testLayout () {
        Reporter.log("<b>Now testing: Management screen layout<b>");
        MonthsCustomersManagementScreen managementPage = new MonthsCustomersManagementScreen(super.driver);
        if (managementPage.isBasicLayoutCorrect())
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>The layout of Management screen is correct. All the main controls are present.");
        else
            Reporter.log("<b><font color=\"ref\">FAILED: </font></b>The layout of Management screen is IN-correct! Certain controls are missing!");
        Assert.assertTrue(managementPage.isBasicLayoutCorrect());
    }
}
