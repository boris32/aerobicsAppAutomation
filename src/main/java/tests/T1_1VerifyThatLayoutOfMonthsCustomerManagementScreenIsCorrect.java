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
public class T1_1VerifyThatLayoutOfMonthsCustomerManagementScreenIsCorrect extends BaseTest {


    public T1_1VerifyThatLayoutOfMonthsCustomerManagementScreenIsCorrect() {
    }

    @Test
    public void testLayout () {
        Reporter.log("<b>Now testing: T1_1VerifyThatLayoutOfMonthsCustomerManagementScreenIsCorrect<b>");
        MonthsCustomersManagementScreen managementPage = new MonthsCustomersManagementScreen(super.driver);
        if (managementPage.isBasicLayoutCorrect())
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>The layout of Management screen is correct. All the main controls are present.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>The layout of Management screen is IN-correct! Certain controls are missing!");
        Assert.assertTrue(managementPage.isBasicLayoutCorrect());
    }
}
