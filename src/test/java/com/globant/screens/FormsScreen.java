package com.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "button-Active")
    private WebElement activeBtn;

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean IsScreenAvailable() {
        return isElementAvailable(activeBtn);
    }


}
