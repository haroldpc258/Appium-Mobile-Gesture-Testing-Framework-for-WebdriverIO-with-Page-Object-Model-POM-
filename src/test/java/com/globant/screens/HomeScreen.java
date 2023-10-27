package com.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Home-screen")
    private WebElement homeBackground;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean IsScreenAvailable() {
        return isElementAvailable(homeBackground);
    }

}
