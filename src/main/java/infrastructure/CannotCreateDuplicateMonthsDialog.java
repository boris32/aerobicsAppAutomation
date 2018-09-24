package infrastructure;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.awt.*;

/**
 * Created by Boris on 9/17/2018.
 */
public class CannotCreateDuplicateMonthsDialog extends BasePage {

    public AppiumDriver<MobileElement> driver;



    private MobileElement cannotCreateDuplicateMonthPopup;
    private MobileElement getCannotCreateDuplicateMonthPopupTitle;
    private MobileElement getCannotCreateDuplicateMonthPopupText;
    private MobileElement cannotCreateDuplicateMonthPopupOkButton;

    public CannotCreateDuplicateMonthsDialog (AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.cannotCreateDuplicateMonthPopup = (MobileElement)driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']"));
        this. getCannotCreateDuplicateMonthPopupTitle = (MobileElement)driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView[@resource-id = 'com.example.boris.myandroidapp:id/errorDialogTitle']");
        this. getCannotCreateDuplicateMonthPopupText = (MobileElement)driver.findElementByXPath("//android.widget.LinearLayout/android.widget.TextView[@resource-id = 'com.example.boris.myandroidapp:id/errorDialogErrorMessage']");
        this. cannotCreateDuplicateMonthPopupOkButton = (MobileElement)driver.findElementByXPath("//android.widget.LinearLayout/android.widget.Button[@resource-id = 'com.example.boris.myandroidapp:id/errorDialogOkButton']");
    }

    //Check if the cannot create duplicate months dialog is displayed
    public boolean isDuplicateMonthsWarningDisplayed () {
        return cannotCreateDuplicateMonthPopup.isDisplayed();
    }

    //Get the title text from cannot create duplicate months dialog
    public String getTitleTextFromCannotCreateDuplicateMonthPopup () {
        return getCannotCreateDuplicateMonthPopupTitle.getText();
    }

    //Get the message text from cannot create duplicate months dialog
    public String getTextFromCannotCreateDuplicateMonthPopup () {
        return getCannotCreateDuplicateMonthPopupText.getText();
    }

    //Press the OK button on create duplicate months dialog
    public void clickOkOnCannotCreateDuplicateMonthPopup() {
        cannotCreateDuplicateMonthPopupOkButton.click();
    }

}
