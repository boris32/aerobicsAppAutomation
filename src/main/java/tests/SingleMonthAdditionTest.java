package tests;

import infrastructure.AddMonthDialog;
import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import infrastructure.myAppUtili;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 8/24/2018.
 */
public class SingleMonthAdditionTest extends BaseTest {

    @Test
    public void AddNewMonth() {
        Reporter.log("<b>Now testing: New Month Addition<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
        AddMonthDialog amd = new AddMonthDialog(driver);

        amd.expandMonthSpinner();
        List<MobileElement> months = amd.getMonthsListInSpinnerAsListOfMobileElements();
        String targetMonth = myAppUtili.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH));
        months.get(Calendar.getInstance().get(Calendar.MONTH)).click();

        amd.expandYearSpinner();
        List<MobileElement> years = amd.getYearsListInSpinnerAsListOfMobileElements();
        int targetYear = Calendar.getInstance().get(Calendar.YEAR) + 1;


        //TODO: Refactor this, fixed quick and dirty
        try {
            for (MobileElement el : years) {
                if (Integer.parseInt(el.getText()) == targetYear)
                    el.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        amd.clickOkButton();

        /*WebElement monthList = mcm.getTheExistingMonthsList();
        if (monthList!=null)
            Reporter.log(String.format("Month List received, containing %d items", 323134234));
        else
            Reporter.log("Month List extraction failed!");*/

        List<MobileElement> monthList = mcm.getExistingMonthAsListOfItems();

        Reporter.log(String.format("Target month/ year to look for: %s, %s",  targetMonth, targetYear));
        Reporter.log("Month list item at index 0 returned: " + monthList.get(0).getText().toString());

        Assert.assertTrue((monthList.get(0).getText().toString().contains(targetMonth + " " + targetYear )));

    }
}
