package tests;

import infrastructure.AddMonthDialog;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 7/18/2018.
 */
public class AddMonthsDialogYearsListTest extends BaseTest{

    @Test
    public void checkYearsList() {
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);
        amd.expandYearSpinner();
        List<String> strYearsActual = amd.getYearsListInSpinnerAsListOfStrings();

        List<String> strYearsExpected = new ArrayList<String>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i=0;i<5;i++)
            strYearsExpected.add(Integer.toString(year + i));

        Assert.assertTrue((strYearsExpected.containsAll(strYearsActual)) && (strYearsExpected.size() == strYearsActual.size()));
    }
}
