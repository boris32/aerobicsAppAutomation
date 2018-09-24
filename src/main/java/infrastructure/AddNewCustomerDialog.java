package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by Boris on 9/24/2018.
 */
public class AddNewCustomerDialog extends BasePage {
    AppiumDriver<MobileElement> driver;

    MobileElement dialogText;
    MobileElement addSelectedCustomer;
    MobileElement addNewCustomer;



    public AddNewCustomerDialog (AppiumDriver<MobileElement> driver) {
        this.driver = driver;

        dialogText = driver.findElementById("com.example.boris.myandroidapp:id/textView");
        addSelectedCustomer = driver.findElementById("com.example.boris.myandroidapp:id/buttonAddSelected");
        addNewCustomer = driver.findElementById("com.example.boris.myandroidapp:id/buttonCreateNewCustomerAcc");
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

    public void clickAddNewCustomer() {
        addNewCustomer.click();
    }

}
