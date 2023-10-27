package com.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseScreen {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @AndroidFindBy(accessibility = "Home")
    protected WebElement homeMenuBarBtn;
    @AndroidFindBy(accessibility = "Webview")
    protected WebElement webviewMenuBarBtn;
    @AndroidFindBy(accessibility = "Login")
    protected WebElement loginMenuBarBtn;
    @AndroidFindBy(accessibility = "Forms")
    protected WebElement formsMenuBarBtn;
    @AndroidFindBy(accessibility = "Swipe")
    protected WebElement swipeMenuBarBtn;
    @AndroidFindBy(accessibility = "Drag")
    protected WebElement dragMenuBarBtn;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public HomeScreen pressHomeBtn() {
        clickOn(homeMenuBarBtn);
        return new HomeScreen(driver);
    }

    public WebviewScreen pressWebviewBtn() {
        clickOn(webviewMenuBarBtn);
        return new WebviewScreen(driver);
    }

    public LoginScreen pressLoginBtn() {
        clickOn(loginMenuBarBtn);
        return new LoginScreen(driver);
    }

    public FormsScreen pressFormsBtn() {
        clickOn(formsMenuBarBtn);
        return new FormsScreen(driver);
    }

    public SwipeScreen pressSwipeBtn() {
        clickOn(swipeMenuBarBtn);
        return new SwipeScreen(driver);
    }

    public DragScreen pressDragBtn() {
        clickOn(dragMenuBarBtn);
        return new DragScreen(driver);
    }

    protected void swipeByCoordinatesToElement(WebElement elementToFind, int xCoordinate, int yCoordinate, String direction, double percent, int speed) {
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("left", xCoordinate);
        params.put("top", yCoordinate);
        params.put("width", 200);
        params.put("height", 200);
        params.put("direction", direction);
        params.put("percent", percent);
        params.put("speed", speed);

        int tries = 0;
        boolean elementExists = false;

        while (!elementExists && tries < 30) {
            try {
                js.executeScript("mobile: swipeGesture", params);
                elementExists = elementToFind.isDisplayed();
            } catch (NoSuchElementException ignored) {
                tries++;
            }
        }
    }

    protected void swipeByElement(WebElement elementToSwipe, String direction, double percent, int speed) {
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("elementId",((RemoteWebElement) elementToSwipe).getId());
        params.put("direction", direction);
        params.put("percent", percent);
        params.put("speed", speed);

        js.executeScript("mobile: swipeGesture", params);
    }

    protected void swipeByElementToElement(WebElement elementToSwipe, WebElement elementToFind, String direction, double percent, int speed) {
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("elementId",((RemoteWebElement) elementToSwipe).getId());
        params.put("direction", direction);
        params.put("percent", percent);
        params.put("speed", speed);

        int tries = 0;
        boolean elementExists = false;

        while (!elementExists && tries < 30) {
            try {
                js.executeScript("mobile: swipeGesture", params);
                elementExists = elementToFind.isDisplayed();
            } catch (NoSuchElementException ignored) {
                tries++;
            }
        }
    }

    protected void dragElementToCoordinates(WebElement elementToDrag, int xCoordinate, int yCoordinate, int speed) {

        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("elementId",((RemoteWebElement) elementToDrag).getId());
        params.put("endX", xCoordinate);
        params.put("endY", yCoordinate);
        params.put("speed", speed);

        js.executeScript("mobile: dragGesture", params);
    }

    protected void scrollByCoordinatesToElement(WebElement elementToFind, int xCoordinate, int yCoordinate, String direction, double percent, int speed) {
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("left", xCoordinate);
        params.put("top", yCoordinate);
        params.put("width", 200);
        params.put("height", 200);
        params.put("direction", direction);
        params.put("percent", percent);
        params.put("speed", speed);

        int tries = 0;
        boolean elementExists = false;

        while (!elementExists && tries < 50) {
            try {
                js.executeScript("mobile: scrollGesture", params);
                elementExists = elementToFind.isDisplayed();
            } catch (NoSuchElementException ignored) {
                tries++;
            }
        }
    }

    protected void scrollByElement(WebElement elementToScroll, String direction, double percent, int speed) {
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) elementToScroll).getId());
        params.put("direction", direction);
        params.put("percent", percent);
        params.put("speed", speed);

        js.executeScript("mobile: scrollGesture", params);
    }

    protected void scrollByElementToElement(WebElement elementToScroll, WebElement elementToFind, String direction, double percent, int speed) {
        JavascriptExecutor js = driver;
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) elementToScroll).getId());
        params.put("direction", direction);
        params.put("percent", percent);
        params.put("speed", speed);

        int tries = 0;
        boolean elementExists = false;

        while (!elementExists && tries < 30) {
            try {
                js.executeScript("mobile: scrollGesture", params);
                elementExists = elementToFind.isDisplayed();
            } catch (NoSuchElementException ignored) {
                tries++;
            }
        }
    }

    protected abstract boolean IsScreenAvailable();

    protected void clickOn(WebElement element) {
        waitVisibilityOf(element);
        waitElementToBeClickable(element);
        element.click();
    }

    protected void writeIn(WebElement element, String text) {
        waitVisibilityOf(element);
        element.sendKeys(text);
    }

    protected boolean isElementAvailable(WebElement element) {
        try {
            waitVisibilityOf(element);
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception ignored) {
            return false;
        }
    }

    protected void waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitAlertToBePresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
