package tests;

import infrastructure.AddMonthDialog;
import infrastructure.BaseTest;
import infrastructure.DataHandler;
import infrastructure.MonthsCustomersManagementScreen;
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
        Reporter.log("<b>Now testing: Years list content on the add month dialog<b>");

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


        if ((strYearsExpected.containsAll(strYearsActual)) && (strYearsExpected.size() == strYearsActual.size()))
            Reporter.log("<b><font color=\"green\">PASSED: </font></b>Months list on the 'Add Month Dialog' contains the correct elements: " + strYearsActual);
        else
            Reporter.log("<b><font color=\"ref\">FAILED: </font></b>Months list on the 'Add Month Dialog' in incorrect: " + strYearsActual);

        Assert.assertTrue((strYearsExpected.containsAll(strYearsActual)) && (strYearsExpected.size() == strYearsActual.size()));
    }
}
