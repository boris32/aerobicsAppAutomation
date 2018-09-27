package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 7/2/2018.
 */
public class AddMonthDialog extends BasePage {

    private AppiumDriver<MobileElement> driver;

    private MobileElement monthSpinner;
    private MobileElement yearSpinner;
    private MobileElement addMonthOk;
    private MobileElement addMonthCancel;
    private MobileElement listOfMonths;
    private MobileElement listOfYears;


    public AddMonthDialog (AppiumDriver<MobileElement> driver) {

        monthSpinner = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/spinnerMonth");
        yearSpinner = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/spinnerYear");
        addMonthOk = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/buttonMonthDialogOk");
        addMonthCancel = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/buttonMonthDialogCancel");



        this.driver = driver;
        //
        //
    }



    //Util:
    /*public void navigateToAddNewMonthDialog() {
        MonthsCustomersManagementScreen mcm = new MonthsCustomersManagementScreen(driver);
        mcm.pressAddNewMonthButton();
    }*/


    public void expandMonthSpinner () {
        monthSpinner.click();
        listOfMonths = (MobileElement) driver.findElementById("android:id/select_dialog_listview");
    }

    public void expandYearSpinner () {
        yearSpinner.click();
        listOfYears = (MobileElement) driver.findElementById("android:id/select_dialog_listview");
    }

    public void clickOkButton() {
        addMonthOk.click();
    }

    public void clickMonthCancel() {
        addMonthCancel.click();
    }

    //Layout comfirmation
    public boolean isAddMonthDialogInitialLayoutCorrect() {
        if (monthSpinner.isDisplayed() && yearSpinner.isDisplayed() && addMonthOk.isDisplayed() && addMonthCancel.isDisplayed()) {
            logger.info(String.format("Checking basic layout on the Add Month Dialog screen\n Is Month Spinner displayed? %s \n Is Year Spinner displayed? %s \n Is Confirmation Button displayed? %s \n Is Cancel Button displayed? %s \n", monthSpinner.isDisplayed(), yearSpinner.isDisplayed(), addMonthOk.isDisplayed(), addMonthCancel.isDisplayed()));
            return true;
        }
        else
            return false;
    }

    //Get list of items in the months list (list opens up from a spinner, providing a selection of 12 individual months - as an overlay on the screen)
    //Get them in form of a list of mobile elements
    public List<MobileElement> getMonthsListInSpinnerAsListOfMobileElements() {
        //Need to locate multiple list elements on the screen, all of which are actually of type (class CheckedTextView)
        List<MobileElement> listedMonths = driver.findElements(By.className("android.widget.CheckedTextView"));
        return listedMonths;
    }

    //Get them in form of a list of Strings
    public List<String> getMonthsListInSpinnerAsListOfStrings() {
        //So we use the previous method to extract the list of TextViews (MobileElements)
        List<MobileElement> list =  getMonthsListInSpinnerAsListOfMobileElements();
        //Create a list for the strings
        List<String> strList = new ArrayList<String>();

        //Populate the string list using the MobileElement list
        for (MobileElement e : list)
            strList.add(e.getText());

        logger.info("Captured items listed in the 'Months' list (months spinner): " + strList);
        return strList;
    }

    //Get list of items in the year list (list opens up from a spinner, providing a selection of 5 years - as an overlay on the screen)
    //Get them in form of a list of mobile elements
    public List<MobileElement> getYearsListInSpinnerAsListOfMobileElements() {
        //Need to locate multiple list elements on the screen, all of which are actually of type (class CheckedTextView)
        List<MobileElement> listedYears = driver.findElements(By.className("android.widget.CheckedTextView"));
        return listedYears;
    }

    //Get them in form of a list of Strings
    public List<String> getYearsListInSpinnerAsListOfStrings() {
        //So we use the previous method to extract the list of TextViews (MobileElements)
        List<MobileElement> list =  getYearsListInSpinnerAsListOfMobileElements();
        //Create a list for the strings
        List<String> strList = new ArrayList<String>();

        //Populate the string list using the MobileElement list
        for (MobileElement e : list)
            strList.add(e.getText());

        logger.info("Captured items listed in the 'Years' list (months spinner): " + strList);
        return strList;
    }

    //Select specific month
    public AddMonthDialog selectMonth(String month) {
        expandMonthSpinner();
        List<MobileElement> months = getMonthsListInSpinnerAsListOfMobileElements();
        for (MobileElement el : months) {
            if (el.getText().toLowerCase().equals(month.toLowerCase())) {
                el.click();
                break;
            }
        }

        return this;
    }

    //Select specific year
    public AddMonthDialog selectYear(String year) {
        expandYearSpinner();
        List<MobileElement> years = getYearsListInSpinnerAsListOfMobileElements();
        for (MobileElement el : years) {
            if (el.getText().toLowerCase().equals(year.toLowerCase())) {
                WebDriverWait waiter = new WebDriverWait(driver, 60);
                waiter.until(ExpectedConditions.elementToBeClickable(el));
                el.click();
                break;
            }
        }

        return this;
    }




}
