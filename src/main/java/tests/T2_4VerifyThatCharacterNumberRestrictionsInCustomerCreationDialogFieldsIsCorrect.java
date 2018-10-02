package tests;

import infrastructure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Boris on 10/1/2018.
 */
public class T2_4VerifyThatCharacterNumberRestrictionsInCustomerCreationDialogFieldsIsCorrect extends BaseTest {


    @Test
    public void verifyCharacterNumberRestrictions() {
        priority = TestCasePriority.P4;
        testCaseId = "T2.4a";

        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        CustomerCreationForm ccf = mcm.pressAddNewCustomerButton().clickAddNewCustomer().enterCustomerFirstName("01234567890123456789012345678901234567890123456789").enterCustomerLastName("01234567890123456789012345678901234567890123456789").enterCustomerUsualFee("01234567890123456789012345678901234567890123456789");

        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, ccf.getFirstNameText().length() == 20, "First Name field accepts up to 20 characters.", "First Name field accepts MORE than 20 characters (exceeds limit)!", testCaseId);

        testCaseId = "T2.4b";
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, ccf.getLastNameText().length() == 20, "Last Name field accepts up to 20 characters.", "Last Name field accepts MORE than 20 characters (exceeds limit)!", testCaseId);

        testCaseId = "T2.4c";
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, ccf.getUsualFeeText().length() == 10, "Usual fee field accepts up to 10 characters.", "Usual fee field accepts MORE than 10 characters (exceeds limit)!", testCaseId);

        sAssert.assertAll();
    }
}
