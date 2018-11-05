package tests;

import infrastructure.*;
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
        priority = TestCasePriority.P4;
        testCaseId = "T2.3a";
        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        CustomerCreationForm ccf = mcm.automaticallyAddNewMonth()
                .pressAddNewCustomerButton()
                .clickAddNewCustomer();


        //Enter first name only
        ccf.enterCustomerFirstName("fname");
        ReportingUtilities.softAssertFalseWithMessage(sAssert, priority, ccf.isCreateButtonEnabled(), "Create button is disabled when only FNAME is populated.", "Create button is enabled when only FNAME is populated!", testCaseId);

        //Now enter last name as well
        testCaseId = "T2.3b";
        ccf.enterCustomerLastName("lname");
        ReportingUtilities.softAssertFalseWithMessage(sAssert, priority, ccf.isCreateButtonEnabled(), "Create button is disabled when only FNAME and LNAME are populated.", "Create button is enabled when only FNAME and LNAME are populated!", testCaseId);

        //Now enter fee as well, you have all three populated - button is now enabled
        testCaseId = "T2.3c";
        ccf.enterCustomerUsualFee("123");
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, ccf.isCreateButtonEnabled(), "Create button is enabled when all three fields are populated.", "Create button is disabled when all three fields are populated!", testCaseId);

        //Clear first name:
        testCaseId = "T2.3d";
        ccf.clearFnameField();
        ReportingUtilities.softAssertFalseWithMessage(sAssert, priority, ccf.isCreateButtonEnabled(), "Create button is disabled when only FNAME is missing.", "Create button is enabled when FNAME is missing!", testCaseId);

        //Now check last name:
        testCaseId = "T2.3e";
        ccf.enterCustomerFirstName("fname repopulated");
        ccf.clearLnameField();
        ReportingUtilities.softAssertFalseWithMessage(sAssert, priority, ccf.isCreateButtonEnabled(), "Create button is disabled when only LNAME is missing.", "Create button is enabled when LNAME is missing!", testCaseId);



        sAssert.assertAll();
    }
}
