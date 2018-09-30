package tests;

import infrastructure.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Boris on 7/7/2018.
 */
public class T1_3VerifyThatMonthsListOnAddMonthDialogIsCorrect extends BaseTest {

    @Test
    public void verifyThatMonthsListIsCorrect() {
        priority = TestCasePriority.P2;
        Reporter.log("<b>Now testing: T1_3VerifyThatMonthsListOnAddMonthDialogIsCorrect<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);
        amd.expandMonthSpinner();
        List<String> actualList = amd.getMonthsListInSpinnerAsListOfStrings();
        List<String> expectedList = new ArrayList<String>();
        Collections.addAll(expectedList, "Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec".split(","));

        ReportingUtilities.assertTrueWithMessage(priority, expectedList.containsAll(actualList) && (expectedList.size() == actualList.size()), " Months list on the 'Add Month Dialog' contains the correct elements: " + actualList, "Months list on the 'Add Month Dialog' in incorrect: " + actualList);
    }
}
