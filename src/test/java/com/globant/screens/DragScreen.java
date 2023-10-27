package com.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DragScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Drag-drop-screen")
    private WebElement screenContainer;
    @AndroidFindBy(accessibility = "drag-l1")
    private WebElement piece1;
    @AndroidFindBy(accessibility = "drag-c1")
    private WebElement piece2;
    @AndroidFindBy(accessibility = "drag-r1")
    private WebElement piece3;
    @AndroidFindBy(accessibility = "drag-l2")
    private WebElement piece4;
    @AndroidFindBy(accessibility = "drag-c2")
    private WebElement piece5;
    @AndroidFindBy(accessibility = "drag-r2")
    private WebElement piece6;
    @AndroidFindBy(accessibility = "drag-l3")
    private WebElement piece7;
    @AndroidFindBy(accessibility = "drag-c3")
    private WebElement piece8;
    @AndroidFindBy(accessibility = "drag-r3")
    private WebElement piece9;
    @AndroidFindBy(accessibility = "drop-l1")
    private WebElement target1;
    @AndroidFindBy(accessibility = "drop-c1")
    private WebElement target2;
    @AndroidFindBy(accessibility = "drop-r1")
    private WebElement target3;
    @AndroidFindBy(accessibility = "drop-l2")
    private WebElement target4;
    @AndroidFindBy(accessibility = "drop-c2")
    private WebElement target5;
    @AndroidFindBy(accessibility = "drop-r2")
    private WebElement target6;
    @AndroidFindBy(accessibility = "drop-l3")
    private WebElement target7;
    @AndroidFindBy(accessibility = "drop-c3")
    private WebElement target8;
    @AndroidFindBy(accessibility = "drop-r3")
    private WebElement target9;
    @AndroidFindBy(uiAutomator = ".classNameMatches(\".*TextView\").text(\"Congratulations\")")
    private WebElement congratulationsTxt;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public boolean IsScreenAvailable() {
        return isElementAvailable(screenContainer);
    }

    public String getCongratulationsText() {
        waitVisibilityOf(congratulationsTxt);
        return congratulationsTxt.getText();
    }

    public void solvePuzzle() {

        List<WebElement> pieces = new ArrayList<>(
                Arrays.asList(piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9));
        List<WebElement> targets = new ArrayList<>(
                Arrays.asList(target1, target2, target3, target4, target5, target6, target7, target8, target9));

        for (int i = 0; i < targets.size(); i++) {
            int xCoordinate = targets.get(i).getLocation().getX() + targets.get(i).getSize().width/2;
            int yCoordinate = targets.get(i).getLocation().getY() + targets.get(i).getSize().height/2;
            dragElementToCoordinates(pieces.get(i), xCoordinate, yCoordinate, 500);
        }
    }

}
