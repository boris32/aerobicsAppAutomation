package tests;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import infrastructure.ReportingUtilities;
import infrastructure.TestCasePriority;
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
        priority = TestCasePriority.P3;
        //Reporter.log("<b>Now testing: T1_1VerifyThatLayoutOfMonthsCustomerManagementScreenIsCorrect<b>");
        MonthsCustomersManagementScreen managementPage = new MonthsCustomersManagementScreen(super.driver);

        ReportingUtilities.assertTrueWithMessage(priority, managementPage.isBasicLayoutCorrect(), "The layout of Management screen is correct. All the main controls are present.", "The layout of Management screen is IN-correct! Certain controls are missing!");
    }
}
