package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

/**
 * Created by Boris on 9/25/2018.
 */
public class CustomerCreationForm extends BasePage {

    AppiumDriver<MobileElement> driver;

    //Interactive elements:
    MobileElement firstNameField;
    MobileElement lastNameField;
    MobileElement usualFeeField;
    MobileElement createButton;
    MobileElement cancelButton;

    //UI elements:
    MobileElement firstNameLabel;
    MobileElement lastNameLabel;
    MobileElement usualFeeLabel;





    public CustomerCreationForm (AppiumDriver<MobileElement> driver) {
        this.driver = driver;

        //Interactive elements:
        firstNameField = driver.findElement(By.id("com.example.boris.myandroidapp:id/editFirstName"));
        lastNameField = driver.findElement(By.id("com.example.boris.myandroidapp:id/editLastName"));
        usualFeeField = driver.findElement(By.id("com.example.boris.myandroidapp:id/editUsualFee"));
        createButton = driver.findElement(By.id("com.example.boris.myandroidapp:id/btnCreateCustomer"));
        cancelButton = driver.findElement(By.id("com.example.boris.myandroidapp:id/btnCancelCustomer"));

        //UI elements:
        firstNameLabel = driver.findElement(By.id("com.example.boris.myandroidapp:id/textView3"));
        lastNameLabel = driver.findElement(By.id("com.example.boris.myandroidapp:id/textView4"));
        usualFeeLabel = driver.findElement(By.id("com.example.boris.myandroidapp:id/usualFeeTextView"));

    }

    public CustomerCreationForm enterCustomerFirstName(String fname) {
        firstNameField.sendKeys(fname);
        return this;
    }

    public CustomerCreationForm enterCustomerLastName(String lname) {
        lastNameField.sendKeys(lname);
        return this;
    }

    public CustomerCreationForm enterCustomerUsualFee(String fee) {
        usualFeeField.sendKeys(fee);
        return this;
    }

    public MonthsCustomersManagementScreen clickCreateButton() {
        createButton.click();
        return new MonthsCustomersManagementScreen(driver);
    }

    public CustomerCreationForm clickCanceleButton() {
        cancelButton.click();
        return this;
    }

    //CREATE NEW CUSTOMER
    public void createNewCustomer (String fName, String lName, String fee) {
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        usualFeeField.sendKeys(fee);
        clickCreateButton();
    }

    public CustomerCreationForm clearFnameField() {
        firstNameField.clear();
        return this;
    }

    public CustomerCreationForm clearLnameField() {
        lastNameField.clear();
        return this;
    }

    public CustomerCreationForm clearFeeField() {
        usualFeeField.clear();
        return this;
    }

    public String getFirstNameText() {
        return firstNameField.getText();
    }

    public String getLastNameText() {
        return lastNameField.getText();
    }

    public String getUsualFeeText() {
        return usualFeeField.getText();
    }

    //LAYOUT
    public boolean verifyCustomerCreationFormDefaultLayout () {
        boolean result = false;
        if (firstNameLabel.getText().equals("First Name:")
                && lastNameLabel.getText().equals("Last Name:")
                && usualFeeLabel.getText().equals("Usual Fee:")
                && firstNameField.isDisplayed()
                && lastNameField.isDisplayed()
                && usualFeeField.isDisplayed()
                && createButton.isDisplayed()
                && !createButton.isEnabled()
                && cancelButton.isDisplayed()
                && cancelButton.isEnabled()
                )
            result = true;

        return result;
    }

    //Is the CREATE button enabled?
    public boolean isCreateButtonEnabled () {
        return createButton.isEnabled();
    }



}
