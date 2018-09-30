package tests;

import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import infrastructure.ReportingUtilities;
import infrastructure.TestCasePriority;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 9/3/2018.
 */
public class T1_6VerifyThatConsecutiveMonthsAdditionWorksProperly extends BaseTest {

    @Test
    public void runMultipleMonthsAdditionTest() {
        priority = TestCasePriority.P0;
        Reporter.log("<b>Now testing: T1_6VerifyThatConsecutiveMonthsAdditionWorksProperly<b>");
        SoftAssert softAssert = new SoftAssert();
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        String targetMonth = "Mar";
        String targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR) +2);
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);
        List<MobileElement> monthList = mcm.getExistingMonthAsListOfItems();
        Reporter.log(String.format("First target month/ year to look for: %s, %s",  targetMonth, targetYear));
        Reporter.log(String.format("Received month and year: %s", monthList.get(0).getText() ));
        /*if (monthList.get(0).getText().toString().contains(targetMonth + " " + targetYear ))
            Reporter.log("<b><font color=\"orange\">SOFT PASS: </font></b>First month addition works.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>Month addition failed!");
        softAssert.assertTrue(monthList.get(0).getText().contains(targetMonth + " " + targetYear ));*/
        ReportingUtilities.softAssertTrueWithMessage(softAssert, priority, monthList.get(0).getText().contains(targetMonth + " " + targetYear ), "First month addition works.", "First month addition failed!");


        targetMonth = "Dec";
        targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);
        monthList = mcm.getExistingMonthAsListOfItems();
        Reporter.log(String.format("Second target month/ year to look for: %s, %s",  targetMonth, targetYear));
        Reporter.log(String.format("Received month and year: %s", monthList.get(0).getText() ));
        ReportingUtilities.softAssertTrueWithMessage(softAssert, priority, monthList.get(0).getText().contains(targetMonth + " " + targetYear ), "Second month addition works.", "Second month addition failed!");

        targetMonth = "Sep";
        targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR) +1);
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);
        monthList = mcm.getExistingMonthAsListOfItems();
        Reporter.log(String.format("Third target month/ year to look for: %s, %s",  targetMonth, targetYear));
        Reporter.log(String.format("Received month and year: %s", monthList.get(0).getText() ));
        ReportingUtilities.softAssertTrueWithMessage(softAssert, priority, monthList.get(0).getText().contains(targetMonth + " " + targetYear ), "Third month addition works.", "Third month addition failed!");

        softAssert.assertAll();




    }

}
