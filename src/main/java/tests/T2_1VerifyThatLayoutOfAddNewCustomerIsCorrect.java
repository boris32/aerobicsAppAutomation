package tests;

import infrastructure.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by Boris on 9/24/2018.
 */
public class T2_1VerifyThatLayoutOfAddNewCustomerIsCorrect extends BaseTest {

    @Test
    public void testAddNewCustomerLayout () {
        priority = TestCasePriority.P3;
        testCaseId = "T2_1";

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewCustomerButton();

        AddNewCustomerDialog ancd = new AddNewCustomerDialog(driver);


        //LOGGING SECTION:
        logger.info("Text from the dialog: " + ancd.getTextFromAddCustomerDialog());
        logger.info("Is the add selected customer button displayed? : " + ancd.getAddSelectedCustomer().isDisplayed());
        logger.info("Is the add selected customer button enabled? : " + ancd.getAddSelectedCustomer().isEnabled());
        logger.info("Is the add new customer button displayed? : " + ancd.getAddNewCustomer().isDisplayed());
        logger.info("Is the add new customer button enabled? : " + ancd.getAddNewCustomer().isEnabled());

        ReportingUtilities.assertTrueWithMessage(priority,
                (ancd.getTextFromAddCustomerDialog().equals("Select existing or add brand new customer: ")
                && ancd.getAddSelectedCustomer().isDisplayed()
                && ancd.getAddSelectedCustomer().isEnabled()==false
                && ancd.getAddNewCustomer().isDisplayed()
                && ancd.getAddNewCustomer().isEnabled() == true),
                "Layout of 'Add New Customer' dialog is correct.",
                "Layout of 'Add New Customer' dialog is NOT correct!", testCaseId);
    }
}
