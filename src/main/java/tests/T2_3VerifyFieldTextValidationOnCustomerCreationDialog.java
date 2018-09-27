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
        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        CustomerCreationForm ccf = mcm.pressAddNewCustomerButton()
            .clickAddNewCustomer();


        //Enter first name only
        ccf.enterCustomerFirstName("fname");
        Reporter.log("When only the first name is populated, create button enabled value is: " + ccf.isCreateButtonEnabled());
        sAssert.assertFalse(ccf.isCreateButtonEnabled());

        //Now enter last name as well
        ccf.enterCustomerLastName("lname");
        Reporter.log("When first and last name is populated, create button enabled value is: " + ccf.isCreateButtonEnabled());
        sAssert.assertFalse(ccf.isCreateButtonEnabled());

        //Now enter fee as well, you have all three populated - button is now enabled
        ccf.enterCustomerUsualFee("123");
        Reporter.log("When all three fields are populated, create button enabled value is: " + ccf.isCreateButtonEnabled());
        sAssert.assertTrue(ccf.isCreateButtonEnabled());

        //Clear first name:
        ccf.clearFnameField();
        Reporter.log("When only last name and fee are populated, create button enabled value is: " + ccf.isCreateButtonEnabled());
        sAssert.assertFalse(ccf.isCreateButtonEnabled());

        //Now check last name:
        ccf.enterCustomerFirstName("fname repopulated");
        ccf.clearLnameField();
        Reporter.log("When only first name and fee are populated, create button enabled value is: " + ccf.isCreateButtonEnabled());
        sAssert.assertFalse(ccf.isCreateButtonEnabled());


        sAssert.assertAll();
    }
}
