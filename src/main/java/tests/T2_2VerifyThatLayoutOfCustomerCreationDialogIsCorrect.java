package tests;

import infrastructure.AddNewCustomerDialog;
import infrastructure.BaseTest;
import infrastructure.CustomerCreationForm;
import infrastructure.MonthsCustomersManagementScreen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by Boris on 9/27/2018.
 */
public class T2_2VerifyThatLayoutOfCustomerCreationDialogIsCorrect extends BaseTest {


    @Test
    public void verifyThatLayoutOfCustomerCreationDialogIsCorrect () {
        Reporter.log("<b>Now testing: T2_2VerifyThatLayoutOfCustomerCreationDialogIsCorrect<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewCustomerButton();
        AddNewCustomerDialog ancd = new AddNewCustomerDialog(driver);
        ancd.clickAddNewCustomer();

        CustomerCreationForm ccf = new CustomerCreationForm(driver);
        if (ccf.verifyCustomerCreationFormDefaultLayout())
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>Default layout of Customer Creation Dialog is correct.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>Default layout of Customer Creation Dialog is IN-correct.");

        Assert.assertTrue(ccf.verifyCustomerCreationFormDefaultLayout());
    }
}
