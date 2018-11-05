package tests;

import infrastructure.*;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 11/5/2018.
 */
public class T2_10VerifyThatUserIsAbleToAddExistingCustomerToAMonth extends BaseTest {
    @Test
    public void verifyT2_10() {
        priority = TestCasePriority.P0;
        testCaseId="T2.10";

        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        mcm.automaticallyAddNewMonth();

        mcm.clickSpecificItemInMonthsList(0)
                .createNewCustomerFromScratch("Tester001_Fname", "Tester001_Lname", "1")
                .createNewCustomerFromScratch("Tester002_Fname", "Tester002_Lname", "2")
                .clickSpecificItemInMonthsList(0);


        mcm.automaticallyAddNewMonth(myAppUtil.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH)), Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+2));

        mcm.clickSpecificItemInMonthsList(1)
                .createNewCustomerFromScratch("Tester003_Fname", "Tester003_Lname", "3")
                .automaticallyAddNewMonth(myAppUtil.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH)), Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+2));

        List<MobileElement> elementsList = mcm.clickSpecificItemInMonthsList(2)
                .addExistingCustomerToMonthFromList(0)
                .addExistingCustomerToMonthFromList(1)
                .addExistingCustomerToMonthFromList(2)
                .clickSpecificItemInMonthsList(0)
                .getExistingCustomersAsListOfItems();


        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList==null?true:!(elementsList.size() > 0), "Newly created customer accounts are NOT added to the un-selected month at index 0", "Newly created customer accounts are WRONGLY added to the un-selected month at index 0", testCaseId);


        elementsList = mcm.clickSpecificItemInMonthsList(1).getExistingCustomersAsListOfItems();
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList==null?true:!(elementsList.size() > 0), "Newly created customer accounts are NOT added to the un-selected month at index 1", "Newly created customer accounts are WRONGLY added to the un-selected month at index 1", testCaseId);

        elementsList = mcm.clickSpecificItemInMonthsList(2).getExistingCustomersAsListOfItems();
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, elementsList.get(0).getText().contains("Tester001_Fname Tester001_Lname") && elementsList.get(1).getText().contains("Tester002_Fname Tester002_Lname") && elementsList.get(1).getText().contains("Tester003_Fname Tester003_Lname"), "Newly created customer accounts are added to the currently ACTIVE month, using list selection", "Newly created customer accounts are MISSING for the currently ACTIVE month, when using list selection", testCaseId);




        try {
            sAssert.assertAll();
        }
        catch (AssertionError e) {
            ReportingUtilities.assertTrueWithMessage(priority, false, "", "Test Case T2.9 experienced a general failure!", testCaseId);
        }
    }
}
