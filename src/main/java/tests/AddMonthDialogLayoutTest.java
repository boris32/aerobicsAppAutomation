package tests;

import infrastructure.AddMonthDialog;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by Boris on 7/6/2018.
 */
public class AddMonthDialogLayoutTest extends BaseTest {


    @Test
    public void verifyAddMonthDialogLayout() {
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);
        Assert.assertTrue(amd.isAddMonthDialogInitialLayoutCorrect());
    }


}
