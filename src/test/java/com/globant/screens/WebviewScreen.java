package com.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement getStartedBtn;
    @AndroidFindBy(uiAutomator = ".classNameMatches(\".*Image\").textMatches(\".*Logo\")")
    private WebElement logo;
    @AndroidFindBy(uiAutomator = ".classNameMatches(\".*WebView\").textMatches(\".*WebdriverIO\")")
    private WebElement screen;

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean IsScreenAvailable() {
        return isElementAvailable(getStartedBtn);
    }

    public void downScroll() {
        /*isElementAvailable(getStartedBtn);
        int xCoordinate = (int) (driver.manage().window().getSize().width/2);
        int yCoordinate = (int) (driver.manage().window().getSize().height * 0.8);
        scrollByCoordinatesToElement(logo, xCoordinate, yCoordinate, "down", 0.95, 700);*/
        isElementAvailable(getStartedBtn);
        //scrollByElement(screen, "down", .95, 600);
        scrollByElementToElement(screen, logo, "down", .95, 600);
    }
}
