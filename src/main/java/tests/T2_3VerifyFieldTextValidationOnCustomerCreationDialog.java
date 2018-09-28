package tests;

import infrastructure.AddNewCustomerDialog;
import infrastructure.BaseTest;
import infrastructure.CustomerCreationForm;
import infrastructure.MonthsCustomersManagementScreen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Boris on 9/27/2018.
 */
public class T2_3VerifyFieldTextValidationOnCustomerCreationDialog extends BaseTest {


    @Test
    public void verifyFieldValidation() {
        Reporter.log("<b>Now testing: T2_3VerifyFieldTextValidationOnCustomerCreationDialog<b>");
        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        CustomerCreationForm ccf = mcm.pressAddNewCustomerButton()
            .clickAddNewCustomer();


        //Enter first name only
        ccf.enterCustomerFirstName("fname");
        if (ccf.isCreateButtonEnabled())
            Reporter.log("<b><font color=\"yellow\">SOFT PASS: </font></b>Create button is disabled when only FNAME is populated.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>Create button is enabled when only FNAME is populated!");
        sAssert.assertFalse(ccf.isCreateButtonEnabled());

        //Now enter last name as well
        ccf.enterCustomerLastName("lname");
        if (ccf.isCreateButtonEnabled())
            Reporter.log("<b><font color=\"yellow\">SOFT PASS: </font></b>Create button is disabled when only FNAME and LNAME are populated.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>Create button is enabled when only FNAME and LNAME are populated!");
        sAssert.assertFalse(ccf.isCreateButtonEnabled());

        //Now enter fee as well, you have all three populated - button is now enabled
        ccf.enterCustomerUsualFee("123");
        if (ccf.isCreateButtonEnabled())
            Reporter.log("<b><font color=\"yellow\">SOFT PASS: </font></b>Create button is enabled when all three fields are populated.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>Create button is disabled when all three fields are populated!");
        sAssert.assertTrue(ccf.isCreateButtonEnabled());

        //Clear first name:
        ccf.clearFnameField();
        if (ccf.isCreateButtonEnabled())
            Reporter.log("<b><font color=\"yellow\">SOFT PASS: </font></b>Create button is disabled when FNAME is missing.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>Create button is enabled when FNAME is missing!");
        sAssert.assertFalse(ccf.isCreateButtonEnabled());

        //Now check last name:
        ccf.enterCustomerFirstName("fname repopulated");
        ccf.clearLnameField();
        if (ccf.isCreateButtonEnabled())
            Reporter.log("<b><font color=\"yellow\">SOFT PASS: </font></b>Create button is disabled when LNAME is missing.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>Create button is enabled when LNAME is missing!");
        sAssert.assertFalse(ccf.isCreateButtonEnabled());


        sAssert.assertAll();
    }
}
