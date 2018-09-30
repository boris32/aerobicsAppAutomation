package tests;

import infrastructure.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by Boris on 9/27/2018.
 */
public class T2_2VerifyThatLayoutOfCustomerCreationDialogIsCorrect extends BaseTest {


    @Test
    public void verifyThatLayoutOfCustomerCreationDialogIsCorrect () {
        priority = TestCasePriority.P3;
        Reporter.log("<b>Now testing: T2_2VerifyThatLayoutOfCustomerCreationDialogIsCorrect<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewCustomerButton();
        AddNewCustomerDialog ancd = new AddNewCustomerDialog(driver);
        ancd.clickAddNewCustomer();

        ReportingUtilities.assertTrueWithMessage(priority, new CustomerCreationForm(driver).verifyCustomerCreationFormDefaultLayout(), "Default layout of Customer Creation Dialog is correct.", "Default layout of Customer Creation Dialog is IN-correct.");
    }
}
