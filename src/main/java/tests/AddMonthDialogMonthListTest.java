package tests;

import infrastructure.AddMonthDialog;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Boris on 7/7/2018.
 */
public class AddMonthDialogMonthListTest extends BaseTest {

    @Test
    public void verifyThatMonthsListIsCorrect() {
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);
        amd.expandMonthSpinner();
        List<String> actualList = amd.getMonthsListInSpinnerAsListOfStrings();
        List<String> expectedList = new ArrayList<String>();
        Collections.addAll(expectedList, "Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec".split(","));
        Assert.assertTrue(expectedList.containsAll(actualList) && (expectedList.size() == actualList.size()));
    }
}
