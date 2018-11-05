package tests;

import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import infrastructure.ReportingUtilities;
import infrastructure.TestCasePriority;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by Boris on 10/2/2018.
 */
public class T2_6VerifyThatMultipleCustomerCreationWorksProperly extends BaseTest {

    @Test
    public void verifyMultipleCustomerCreation () {
        priority = TestCasePriority.P0;
        testCaseId = "T2.6a";

        SoftAssert sAssert = new SoftAssert();

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        String testFName1 = "FirstName001";
        String testLName1 = "LastName001";
        String testFee1 = "1000";
        mcm.automaticallyAddNewMonth().pressAddNewCustomerButton().clickAddNewCustomer().enterCustomerFirstName(testFName1).enterCustomerLastName(testLName1).enterCustomerUsualFee(testFee1).clickCreateButton();



        String testFName2 = "FirstName002";
        String testLName2 = "LastName002";
        String testFee2 = "2000";
        mcm.pressAddNewCustomerButton().clickAddNewCustomer().enterCustomerFirstName(testFName2).enterCustomerLastName(testLName2).enterCustomerUsualFee(testFee2).clickCreateButton();


        String testFName3 = "FirstName003";
        String testLName3 = "LastName003";
        String testFee3 = "3000";
        List<MobileElement> customersList =  mcm.pressAddNewCustomerButton().clickAddNewCustomer().enterCustomerFirstName(testFName3).enterCustomerLastName(testLName3).enterCustomerUsualFee(testFee3).clickCreateButton().getExistingCustomersAsListOfItems();


        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, (customersList.get(0).getText().toString().contains(testFName1 + " " + testLName1)), "First customer account created properly.", "First customer account creation failed.", testCaseId);
        testCaseId = "T2.6b";
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, (customersList.get(1).getText().toString().contains(testFName2 + " " + testLName2)), "Second customer account created properly.", "Second customer account creation failed.", testCaseId);
        testCaseId = "T2.6c";
        ReportingUtilities.softAssertTrueWithMessage(sAssert, priority, (customersList.get(2).getText().toString().contains(testFName3 + " " + testLName3)), "Third customer account created properly.", "Third customer account creation failed.", testCaseId);

        sAssert.assertAll();
    }
}
