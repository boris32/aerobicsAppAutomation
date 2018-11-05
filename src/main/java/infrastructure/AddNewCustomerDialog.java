package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boris on 9/24/2018.
 */
public class AddNewCustomerDialog extends BasePage {
    AppiumDriver<MobileElement> driver;

    MobileElement dialogText;
    MobileElement addSelectedCustomer;
    MobileElement addNewCustomer;
    MobileElement existingCustomersSpinner;
    MobileElement existingCustomersListView;



    public AddNewCustomerDialog (AppiumDriver<MobileElement> driver) {
        this.driver = driver;

        dialogText = driver.findElementById("com.example.boris.myandroidapp:id/textView");
        addSelectedCustomer = driver.findElementById("com.example.boris.myandroidapp:id/buttonAddSelected");
        addNewCustomer = driver.findElementById("com.example.boris.myandroidapp:id/buttonCreateNewCustomerAcc");
        existingCustomersSpinner = driver.findElementById("com.example.boris.myandroidapp:id/spinerPickCustomerToAdd");
    }

    public String getTextFromAddCustomerDialog () {
        return dialogText.getText();
    }

    public MobileElement getAddSelectedCustomer () {
        return addSelectedCustomer;
    }

    public MobileElement getAddNewCustomer () {
        return addNewCustomer;
    }

    public void clickAddSelectedCustomerButton () {
        addSelectedCustomer.click();
    }

    public CustomerCreationForm clickAddNewCustomer() {
        addNewCustomer.click();
        return new CustomerCreationForm(driver);
    }

    public MobileElement getExistingCustomersListView () {
        return existingCustomersListView = driver.findElement(By.className("android.widget.ListView"));
    }

    public AddNewCustomerDialog expandExistingCustomersSpinner() {
        existingCustomersSpinner.click();
        return this;
    }

    public MobileElement getExistingCustomersSpinner () {
        return existingCustomersSpinner;
    }

    public List<MobileElement> getExistingCustomersListAsListOfElements() {
        //List<String> existingCustomersList = new ArrayList<String>();
        List<MobileElement> listItems = driver.findElementsByXPath("//android.widget.ListView/android.widget.CheckedTextView");

        return listItems;
    }

    public MonthsCustomersManagementScreen dismissCustomerCreationForm() {
        TouchAction action = new TouchAction((MobileDriver)driver);
        action.tap(PointOption.point(50,50)).perform();

        return new MonthsCustomersManagementScreen(driver);
    }

    public AddNewCustomerDialog dismissExistingCustomersSpinner() {
        TouchAction action = new TouchAction((MobileDriver)driver);
        action.tap(PointOption.point(50,50)).perform();

        return this;
    }



}
