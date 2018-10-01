package tests;

import infrastructure.*;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 8/24/2018.
 */
public class T1_5VerifyThatBasicMonthsAdditionWorksProperly extends BaseTest {

    @Test
    public void AddNewMonth() {
        priority = TestCasePriority.P0;
        testCaseId = "T1.5";
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);



        int targetYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
        String targetMonth = myAppUtil.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH));
        mcm.automaticallyAddNewMonth(targetMonth, Integer.toString(targetYear));


        List<MobileElement> monthList = mcm.getExistingMonthAsListOfItems();


        logger.info(String.format("Target month/ year to look for: %s, %s",  targetMonth, targetYear));
        logger.info("Month list item at index 0 returned: " + monthList.get(0).getText().toString());

        ReportingUtilities.assertTrueWithMessage(priority, (monthList.get(0).getText().toString().contains(targetMonth + " " + targetYear )), "Basic month addition works.", "Basic month addition doesn't work!", testCaseId);
    }
}
