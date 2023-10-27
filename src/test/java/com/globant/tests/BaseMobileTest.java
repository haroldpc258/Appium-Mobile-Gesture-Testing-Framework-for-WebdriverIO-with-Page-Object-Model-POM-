package com.globant.tests;

import com.globant.screens.HomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseMobileTest {

    protected AndroidDriver driver;


    @BeforeMethod
    @Parameters({ "hostAddress" })
    public void setUp(String hostAddress) {
        DesiredCapabilities caps = new DesiredCapabilities();
        FileReader reader;
        try {
            String path = System.getProperty("user.dir");
            reader = new FileReader(path + "/src/test/resources/capabilities.json");
            setDesiredCapabilities(reader, caps);
            driver = new AndroidDriver(new URL(hostAddress), caps);
        } catch (FileNotFoundException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(Duration.ofSeconds(2));
            driver.quit();
        }
    }

    private void setDesiredCapabilities(FileReader reader, DesiredCapabilities caps) {
        JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
        caps.setCapability("deviceName", jsonObject.getString("deviceName"));
        caps.setCapability("appPackage", jsonObject.getString("appPackage"));
        caps.setCapability("appActivity", jsonObject.getString("appActivity"));
        caps.setCapability("platformName", jsonObject.getString("platformName"));
        caps.setCapability("automationName", jsonObject.getString("automationName"));
    }

    protected HomeScreen loadFirstScreen() {
        return new HomeScreen(driver);
    }
}
