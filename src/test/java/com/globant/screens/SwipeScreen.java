package com.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Swipe-screen")
    private WebElement swipeScreenContainer;
    @AndroidFindBy(className = "android.widget.HorizontalScrollView")
    private WebElement cardsContainer;
    @AndroidFindBy(accessibility = "card")
    private WebElement swipeCard;
    @AndroidFindBy(uiAutomator = ".classNameMatches(\".*TextView\").text(\"COMPATIBLE\")")
    private WebElement compatibleText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You found me!!!\"]")
    private WebElement found;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsScreenAvailable() {
        return isElementAvailable(swipeScreenContainer);
    }

    public boolean leftSwipeGesturedWasPerformed() {
        return isElementAvailable(compatibleText);
    }

    public boolean upSwipeGesturedWasPerformed() {
        return isElementAvailable(found);
    }

    public void leftSwipe() {
        swipeByCoordinatesToElement(compatibleText, 750, 1500, "left", 0.95, 500);
    }

    public void upSwipe() {
        /*int xCoordinate = (int) (driver.manage().window().getSize().width/2);
        int yCoordinate = (int) (driver.manage().window().getSize().height * 0.9);
        swipeByCoordinatesToElement(logo, xCoordinate, yCoordinate, "up", 0.9, 500);*/
        swipeByElementToElement(swipeScreenContainer, found, "up", 0.95, 500);
    }
}
