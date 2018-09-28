package tests;

import infrastructure.AddMonthDialog;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
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
        Reporter.log("<b>Now testing: T1_2VerifyThatLayoutOfAddMonthsDialogIsCorrect<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);
        if (amd.isAddMonthDialogInitialLayoutCorrect())
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>The layout of 'Add Month Dialog' is correct. All the main controls are present.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>The layout of 'Add Month Dialog' is IN-correct. Certain controls are missing!");
        Assert.assertTrue(amd.isAddMonthDialogInitialLayoutCorrect());
    }


}
