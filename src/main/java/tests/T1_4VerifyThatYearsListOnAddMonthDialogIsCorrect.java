package tests;

import infrastructure.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 7/18/2018.
 */
public class T1_4VerifyThatYearsListOnAddMonthDialogIsCorrect extends BaseTest{

    @Test
    public void checkYearsList() {
        priority = TestCasePriority.P2;
        Reporter.log("<b>Now testing: T1_4VerifyThatYearsListOnAddMonthDialogIsCorrect<b>");

        DataHandler dh = new DataHandler();
        try {
            dh.test();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);
        amd.expandYearSpinner();
        List<String> strYearsActual = amd.getYearsListInSpinnerAsListOfStrings();

        List<String> strYearsExpected = new ArrayList<String>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i=0;i<3;i++)
            strYearsExpected.add(Integer.toString(year + i));

        ReportingUtilities.assertTrueWithMessage(priority, (strYearsExpected.containsAll(strYearsActual)) && (strYearsExpected.size() == strYearsActual.size()), "Months list on the 'Add Month Dialog' contains the correct elements: " + strYearsActual, ">Months list on the 'Add Month Dialog' in incorrect: " + strYearsActual);
    }
}
