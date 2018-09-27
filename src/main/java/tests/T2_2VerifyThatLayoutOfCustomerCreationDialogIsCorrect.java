package tests;

import infrastructure.AddNewCustomerDialog;
import infrastructure.BaseTest;
import infrastructure.CustomerCreationForm;
import infrastructure.MonthsCustomersManagementScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Boris on 9/27/2018.
 */
public class T2_2VerifyThatLayoutOfCustomerCreationDialogIsCorrect extends BaseTest {


    @Test
    public void verifyThatLayoutOfCustomerCreationDialogIsCorrect () {
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewCustomerButton();
        AddNewCustomerDialog ancd = new AddNewCustomerDialog(driver);
        ancd.clickAddNewCustomer();

        Assert.assertTrue(new CustomerCreationForm(driver).verifyCustomerCreationFormDefaultLayout());
    }
}
