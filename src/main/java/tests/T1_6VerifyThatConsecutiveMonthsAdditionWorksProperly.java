package tests;

import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
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
        Reporter.log("<b>Now testing: Multiple Month Addition<b>");
        SoftAssert softAssert = new SoftAssert();
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        String targetMonth = "Mar";
        String targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR) +2);
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);
        List<MobileElement> monthList = mcm.getExistingMonthAsListOfItems();
        Reporter.log(String.format("First target month/ year to look for: %s, %s",  targetMonth, targetYear));
        Reporter.log(String.format("Received month and year: %s", monthList.get(0).getText() ));
        softAssert.assertTrue(monthList.get(0).getText().contains(targetMonth + " " + targetYear ));

        targetMonth = "Dec";
        targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);
        monthList = mcm.getExistingMonthAsListOfItems();
        Reporter.log(String.format("Second target month/ year to look for: %s, %s",  targetMonth, targetYear));
        Reporter.log(String.format("Received month and year: %s", monthList.get(0).getText() ));
        softAssert.assertTrue(monthList.get(0).getText().contains(targetMonth + " " + targetYear));

        targetMonth = "Sep";
        targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR) +1);
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);
        monthList = mcm.getExistingMonthAsListOfItems();
        Reporter.log(String.format("Third target month/ year to look for: %s, %s",  targetMonth, targetYear));
        Reporter.log(String.format("Received month and year: %s", monthList.get(0).getText() ));
        softAssert.assertTrue(monthList.get(0).getText().contains(targetMonth + " " + targetYear));

        softAssert.assertAll();




    }

}
