package tests;

import infrastructure.*;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Boris on 10/1/2018.
 */
public class T2_5VerifyThatBasicCustomerCreationWorksProperly extends BaseTest {

    @Test
    public void customerCreation() {
        priority = TestCasePriority.P0;
        testCaseId = "T2.5";

        String testFName = "FirstNameTester";
        String testLName = "LastNameTester";
        String testFee = "1000";
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        List<MobileElement> customersList = mcm.automaticallyAddNewMonth()
                .pressAddNewCustomerButton()
                .clickAddNewCustomer()
                .enterCustomerFirstName(testFName)
                .enterCustomerLastName(testLName)
                .enterCustomerUsualFee(testFee)
                .clickCreateButton()
                .getExistingCustomersAsListOfItems();

        ReportingUtilities.assertTrueWithMessage(priority, (customersList.get(0).getText().toString().contains(testFName + " " + testLName)), "Basic customer addition works.", "Basic customer addition doesn't work!", testCaseId);

    }
}
