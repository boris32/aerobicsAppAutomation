package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Boris on 6/29/2018.
 */
public class MonthsCustomersManagementScreen extends BasePage {
        private MobileElement addNewMonth;
        private MobileElement addNewCustomer;
        private MobileElement monthsList;
        private MobileElement customerList;
        private MobileElement customerDetails;
        private AppiumDriver<MobileElement> driver;
        private List<MobileElement> monthsListItems;
        private List<MobileElement> customerListItems;




    public MonthsCustomersManagementScreen (AppiumDriver<MobileElement> driver) {
            this.driver = driver;
            //addNewMonth = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/addNewMonth");
            addNewMonth = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='+ ADD NEW']");
            addNewCustomer = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/buttonAddNewCustomer");
            monthsList = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/MonthsList");
            customerList = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/CustomerList");
            customerDetails = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/textView2");
        }




        //GERENAL METHODS:
        //Confirming that vital layout elements are present on page load
        public boolean isBasicLayoutCorrect() {
            super.logger.info(String.format("Checking basic layout on the Management screen\n Add New Month button present? %s \n Add New Customer button present? %s \n Month list present? %s \n Customer list " +
                    "present?" + " %s \n Customer details present? %s \n + is Add Customer button enabled? %s", addNewMonth.isDisplayed(), addNewCustomer.isDisplayed(), monthsList.isDisplayed(), customerList.isDisplayed(),
                    customerDetails.isDisplayed(), addNewCustomer.isEnabled()));

            if (addNewMonth.isDisplayed() && addNewCustomer.isDisplayed() && !addNewCustomer.isEnabled() && monthsList.isDisplayed() && customerList.isDisplayed() && customerDetails.isDisplayed()) {


                return true;
            }
            else
                return false;
        }

        //MONTH RELATED METHODS:
        public AddMonthDialog pressAddNewMonthButton () {
            addNewMonth.click();
            return new AddMonthDialog(driver);
        }

        public WebElement getTheExistingMonthsList() {
            return monthsList;
        }

        public List<MobileElement> getExistingMonthAsListOfItems () {
            monthsListItems = driver.findElements(By.xpath("//android.widget.ListView[@resource-id='com.example.boris.myandroidapp:id/MonthsList']/android.widget.TextView"));

            return monthsListItems;
        }


        public void automaticallyAddNewMonth(String desiredMonth, String desiredYear) {

            pressAddNewMonthButton();
            AddMonthDialog amd = new AddMonthDialog(driver);

            amd.expandMonthSpinner();
            List<MobileElement> months = amd.getMonthsListInSpinnerAsListOfMobileElements();
            for (MobileElement el : months) {
                if (el.getText().toLowerCase().equals(desiredMonth.toLowerCase())) {
                    el.click();
                    break;
                }
            }

            amd.expandYearSpinner();
            List<MobileElement> years = amd.getYearsListInSpinnerAsListOfMobileElements();
            for (MobileElement el : years) {
                if (el.getText().toLowerCase().equals(desiredYear.toLowerCase())) {
                    el.click();
                    break;
                }
            }

            amd.clickOkButton();

            //return this;
        }

        //Starts from main screen, creates a new month then returns user to the main screen again
        public MonthsCustomersManagementScreen createNewMonthFromScratch (String desiredMonth, String desiredYear) {
            pressAddNewMonthButton()
                    .selectMonth(desiredMonth)
                    .selectYear(desiredYear)
                    .clickOkButton();
            return this;
        }


        //CUSTOMER RELATED METHODS

        //Starts from main screen, creates a new customer then returns user to the main screen again
        public MonthsCustomersManagementScreen createNewCustomerFromScratch(String fName, String lName, String fee) {
            pressAddNewCustomerButton()
                    .clickAddNewCustomer()
                    .createNewCustomer(fName, lName, fee);
            return this;
        }

        public AddNewCustomerDialog pressAddNewCustomerButton () {
            addNewCustomer.click();
            return new AddNewCustomerDialog(driver);
        }

    public List<MobileElement> getExistingCustomersAsListOfItems () {
        customerListItems = driver.findElements(By.xpath("//android.widget.ListView[@resource-id='com.example.boris.myandroidapp:id/CustomerList']/android.widget.TextView"));

        return customerListItems;
    }






}
