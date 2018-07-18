package tests;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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
        MonthsCustomersManagementScreen managementPage = new MonthsCustomersManagementScreen(super.driver);
        Assert.assertTrue(managementPage.isBasicLayoutCorrect());
    }
}
