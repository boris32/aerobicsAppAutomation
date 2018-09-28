package tests;

import infrastructure.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by Boris on 9/17/2018.
 */
public class T1_7VerifyThatUserIsPreventedFromCreatingMultipleMonths extends BaseTest {


    @Test
    public void TryToCreateDuplicateMonths() {
        Reporter.log("<b>Now testing: T1_7VerifyThatUserIsPreventedFromCreatingMultipleMonths<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);

        //Create a month instance
        String targetMonth = myAppUtil.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH));
        String targetYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        mcm.automaticallyAddNewMonth(targetMonth, targetYear);

        //Try to create an identical month instance
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);
        amd.selectMonth(targetMonth);
        amd.selectYear(targetYear);
        amd.clickOkButton();

        CannotCreateDuplicateMonthsDialog ccdmd = new CannotCreateDuplicateMonthsDialog(driver);



        Reporter.log("Is the 'duplicaet month' dialog displayed?" + ccdmd.isDuplicateMonthsWarningDisplayed());
        String desiredTitleText = "SORRY!";
        String actualTitleText = ccdmd.getTitleTextFromCannotCreateDuplicateMonthPopup();
        Reporter.log("Dialog title reads as follows: " + ccdmd.getTitleTextFromCannotCreateDuplicateMonthPopup());
        String desiredMessageText = "The month - year combination that you have selected is already in use. Please check the Months list at the left-hand side of main app screen.";
        Reporter.log("Dialog message reads as follows: " + ccdmd.getTextFromCannotCreateDuplicateMonthPopup());
        String actualMessageText = ccdmd.getTextFromCannotCreateDuplicateMonthPopup();

        if (ccdmd.isDuplicateMonthsWarningDisplayed() && desiredTitleText.equals(actualTitleText) && desiredMessageText.equals(actualMessageText))
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>User prevented from adding duplicate months.");
        else
            Reporter.log("<b><font color=\"red\">FAILED: </font></b>User NOT prevented from adding duplicate months!");

        Assert.assertTrue(ccdmd.isDuplicateMonthsWarningDisplayed() && desiredTitleText.equals(actualTitleText) && desiredMessageText.equals(actualMessageText));
    }
}
