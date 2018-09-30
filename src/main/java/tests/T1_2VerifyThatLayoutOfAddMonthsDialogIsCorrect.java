package tests;

import infrastructure.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by Boris on 7/6/2018.
 */
public class T1_2VerifyThatLayoutOfAddMonthsDialogIsCorrect extends BaseTest {


    @Test
    public void verifyAddMonthDialogLayout() {
        priority = TestCasePriority.P3;
        //Reporter.log("<b>Now testing: T1_2VerifyThatLayoutOfAddMonthsDialogIsCorrect<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);

        ReportingUtilities.assertTrueWithMessage(priority, amd.isAddMonthDialogInitialLayoutCorrect(), "The layout of 'Add Month Dialog' is correct. All the main controls are present.", "The layout of 'Add Month Dialog' is IN-correct. Certain controls are missing!");
    }


}
