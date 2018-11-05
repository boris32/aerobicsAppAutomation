package tests;

import infrastructure.*;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 10/30/2018.
 */
public class T2_9VerifyThatUserIsAbleToAddExistingCustomerToAMonth extends BaseTest {

    @Test
    public void verifyT2_9() {
        priority = TestCasePriority.P0;
        testCaseId="T2.9";

        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        mcm.automaticallyAddNewMonth();
        mcm.automaticallyAddNewMonth(myAppUtil.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH)), Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+1));


        List<MobileElement> elementsList = mcm.clickSpecificItemInMonthsList(1)
                .createNewCustomerFromScratch("Tester001_Fname", "Tester001_Lname", "1")
                .createNewCustomerFromScratch("Tester002_Fname", "Tester002_Lname", "2")
                .clickSpecificItemInMonthsList(0)
                .getExistingCustomersAsListOfItems();

        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList==null?true:!(elementsList.size() > 0), "Newly created customer accounts are NOT added to the un-selected month", "Newly created customer accounts are WRONGLY added to the un-selected month", testCaseId);

        elementsList = mcm.clickSpecificItemInMonthsList(1).getExistingCustomersAsListOfItems();
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList.get(0).getText().contains("Tester001_Fname Tester001_Lname") && elementsList.get(1).getText().contains("Tester002_Fname Tester002_Lname"), "Newly created customer accounts are  added to the currently ACTIVE month", "Newly created customer accounts are MISSING for the currently ACTIVE month", testCaseId);

        try {
            sAssert.assertAll();
        }
        catch (AssertionError e) {
            ReportingUtilities.assertTrueWithMessage(priority, false, "", "Test Case T2.9 experienced a general failure!", testCaseId);
        }
    }
}
