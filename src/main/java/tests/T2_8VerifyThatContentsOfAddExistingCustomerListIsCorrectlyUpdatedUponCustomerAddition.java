package tests;

import infrastructure.*;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 10/25/2018.
 */
public class T2_8VerifyThatContentsOfAddExistingCustomerListIsCorrectlyUpdatedUponCustomerAddition extends BaseTest {

    @Test
    public void testT2_8() {
        priority = TestCasePriority.P1;
        testCaseId = "T2.8";

        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        //Create new customer
        String targetMonth = myAppUtil.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH));
        String targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);


        AddNewCustomerDialog ccf = mcm.pressAddNewCustomerButton();
        MobileElement spinner = ccf.getExistingCustomersSpinner();
        ReportingUtilities.softAssertFalseWithMessage(sAssert, priority, spinner.isEnabled(), "The add existing customers list is disabled, as it should be", "The add existing customers list is enabled, which is not right", testCaseId);

        ccf.clickAddNewCustomer().createNewCustomer("test1", "test2", "12");
        //get the list of all previously created customer accounts
        List<MobileElement> elementsList = mcm.pressAddNewCustomerButton()
                .expandExistingCustomersSpinner()
                .getExistingCustomersListAsListOfElements();

        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList.get(0).getText().toString().contains("Test1") && elementsList.get(0).getText().toString().contains("Test2"), "Newly created customer is now included into the add existing customers list", "Newly created customer is NOT included into the add existing customers list", testCaseId);

        ccf.dismissExistingCustomersSpinner().dismissCustomerCreationForm();


        mcm.pressAddNewCustomerButton().clickAddNewCustomer().createNewCustomer("test3", "test4", "34");
        //get the list of all previously created customer accounts AGAIN
        elementsList = mcm.pressAddNewCustomerButton()
                .expandExistingCustomersSpinner()
                .getExistingCustomersListAsListOfElements();

        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList.get(1).getText().toString().contains("Test3") && elementsList.get(1).getText().toString().contains("Test4"), "Newly created customer is now included into the add existing customers list", "Latest created customer is NOT included into the add existing customers list", testCaseId);
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList.get(0).getText().toString().contains("Test1") && elementsList.get(0).getText().toString().contains("Test2"), "Newly created customer is now included into the add existing customers list", "Latest created customer is NOT included into the add existing customers list", testCaseId);


        try {
            sAssert.assertAll();
        }
        catch (AssertionError e) {
            ReportingUtilities.assertTrueWithMessage(priority, false, "", "Test Case T2.8 experienced a general failure!", testCaseId);
        }
    }
}
