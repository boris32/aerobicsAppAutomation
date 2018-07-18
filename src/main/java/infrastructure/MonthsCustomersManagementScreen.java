package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.awt.*;

/**
 * Created by Boris on 6/29/2018.
 */
public class MonthsCustomersManagementScreen extends BasePage {
        private MobileElement addNewMonth;
        private MobileElement addNewCustomer;
        private MobileElement monthsList;
        private MobileElement customerList;
        private MobileElement customerDetails;




    public MonthsCustomersManagementScreen (AppiumDriver<MobileElement> driver) {
            addNewMonth = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/addNewMonth");
            addNewCustomer = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/buttonAddNewCustomer");
            monthsList = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/MonthsList");
            customerList = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/CustomerList");
            customerDetails = (MobileElement) driver.findElementById("com.example.boris.myandroidapp:id/textView2");
        }




        //GERENAL METHODS:
        //Confirming that vital layout elements are present on page load
        public boolean isBasicLayoutCorrect() {
            super.logger.info(String.format("Checking basic layout on the Management screen\n Add New Month button present? %s \n Add New Customer button present? %s \n Month list present? %s \n Customer list " +
                    "present?" + " %s \n Customer details present? %s \n", addNewMonth.isDisplayed(), addNewCustomer.isDisplayed(), monthsList.isDisplayed(), customerList.isDisplayed(),
                    customerDetails.isDisplayed()));

            if (addNewMonth.isDisplayed() && addNewCustomer.isDisplayed() && monthsList.isDisplayed() && customerList.isDisplayed() && customerDetails.isDisplayed()) {


                return true;
            }
            else
                return false;
        }

        //MONTH RELATED METHODS:
        public void pressAddNewMonthButton () {
            addNewMonth.click();
        }

        //CUSTOMER RELATED METHODS
        public void pressAddNewCustomerButton () {
            addNewCustomer.click();
        }

}
