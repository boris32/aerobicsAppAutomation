package tests;

import infrastructure.AddNewCustomerDialog;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by Boris on 9/24/2018.
 */
public class T2_1VerifyThatLayoutOfAddNewCustomerIsCorrect extends BaseTest {

    @Test
    public void testAddNewCustomerLayout () {
        Reporter.log("<b>Now testing: T2_1VerifyThatLayoutOfAddNewCustomerIsCorrect<b>");

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewCustomerButton();

        AddNewCustomerDialog ancd = new AddNewCustomerDialog(driver);


        //LOGGING SECTION:
        Reporter.log("Text from the dialog: " + ancd.getTextFromAddCustomerDialog());
        Reporter.log("Is the add selected customer button displayed? : " + ancd.getAddSelectedCustomer().isDisplayed());
        Reporter.log("Is the add selected customer button enabled? : " + ancd.getAddSelectedCustomer().isEnabled());
        Reporter.log("Is the add new customer button displayed? : " + ancd.getAddNewCustomer().isDisplayed());
        Reporter.log("Is the add new customer button enabled? : " + ancd.getAddNewCustomer().isEnabled());

        if (ancd.getTextFromAddCustomerDialog().equals("Select existing or add brand new customer: ")
                && ancd.getAddSelectedCustomer().isDisplayed()
                && ancd.getAddSelectedCustomer().isEnabled()==false
                && ancd.getAddNewCustomer().isDisplayed()
                && ancd.getAddNewCustomer().isEnabled() == true)
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>Layout of 'Add New Customer' dialog is correct.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></bLayout of 'Add New Customer' dialog is NOT correct!");

        Assert.assertTrue(ancd.getTextFromAddCustomerDialog().equals("Select existing or add brand new customer: ")
                && ancd.getAddSelectedCustomer().isDisplayed()
                && ancd.getAddSelectedCustomer().isEnabled()==false
                && ancd.getAddNewCustomer().isDisplayed()
                && ancd.getAddNewCustomer().isEnabled() == true);
    }
}
