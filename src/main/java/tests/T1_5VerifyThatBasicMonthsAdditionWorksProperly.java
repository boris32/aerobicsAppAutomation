package tests;

import infrastructure.BaseTest;
import infrastructure.MonthsCustomersManagementScreen;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import infrastructure.myAppUtil;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 8/24/2018.
 */
public class T1_5VerifyThatBasicMonthsAdditionWorksProperly extends BaseTest {

    @Test
    public void AddNewMonth() {
        Reporter.log("<b>Now testing: New Month Addition<b>");
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);



        int targetYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
        String targetMonth = myAppUtil.getMonthAbbrev(Calendar.getInstance().get(Calendar.MONTH));

        mcm.automaticallyAddNewMonth(targetMonth, Integer.toString(targetYear));
        /*
        //TODO: Refactor this, fixed quick and dirty
        try {
            for (MobileElement el : years) {
                if (Integer.parseInt(el.getText()) == targetYear) {
                    el.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        amd.clickOkButton();*/

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
